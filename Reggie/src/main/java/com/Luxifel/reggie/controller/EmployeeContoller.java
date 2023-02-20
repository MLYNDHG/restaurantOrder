package com.Luxifel.reggie.controller;

import com.Luxifel.reggie.exception.MyException;
import com.Luxifel.reggie.mbg.model.Employee;
import com.Luxifel.reggie.service.EmployeeService;
import com.Luxifel.reggie.utils.QueryListRequest;
import com.Luxifel.reggie.utils.QueryListResult;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.Date;

@RestController
@RequestMapping("/employee")
public class EmployeeContoller {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CacheManager cacheManager;

    @PostMapping("/login")
    public Employee login (HttpServletRequest httpServletRequest, @RequestBody Employee employee){
        Employee result = null;
        //1.password使用md5加密   此处应该前端加密传给后端才是正确的处理  且1前端需要给用户名密码判空
        String password =employee.getPassword();
        String username =employee.getUsername();
        if(StringUtils.isEmpty(password)||StringUtils.isEmpty(username)){
            throw new MyException("账户密码为空!");
        }
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2.使用username查询数据库
        Employee employee1 = employeeService.selectByEmployeeName(employee.getUsername());

        //3.查询无数据则返回登陆失败
        if(employee1 == null){
            throw new MyException("账号||密码不正确!");
        }
        //4.密码对比、不一致 返回登陆失败
        if(!employee1.getPassword().equals(password)){
            throw new MyException("账号||密码不正确!");
        }
        //5.查看员工状态 禁用则返回禁用结果
        if(employee1.getStatus()==0){
            throw new MyException("该账户已经被冻结!");
        }

        //6.登录成功 id存入session  返回登录成功
        httpServletRequest.getSession().setAttribute("employee",employee1.getId());
        return employee1;
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().removeAttribute("employee");
        return "退出成功!";
    }

    @PostMapping("/page")
    @Cacheable(value = "employeeListCache",key = "'list'")
    public QueryListResult<Employee> employeeList(@RequestBody QueryListRequest<Employee> queryListRequest){
        return employeeService.EmployeeList(queryListRequest);
    }

    @GetMapping("/{id}")
    @Cacheable(value = "EmployeeCache",key = "#id")
    public Employee getEmployeeById(@PathVariable(value = "id")  Long id){
        return employeeService.selectByPrimaryKey(id);
    }

    @PostMapping("")
    @CacheEvict(value = "employeeListCache",key = "'list'")
    public int insertIntoEmpoyee(HttpServletRequest request,@RequestBody Employee employee){
        String password = DigestUtils.md5DigestAsHex("123456".getBytes());
        employee.setPassword(password);
        Date date =new Date();
        employee.setCreateTime(date);
        employee.setUpdateTime(date);
        Long Id = (Long) request.getSession().getAttribute("employee");
        employee.setCreateUser(Id);
        employee.setUpdateUser(Id);
        return employeeService.insertSelective(employee);
    }

    @PutMapping("")
    public int editEmpoyee(HttpServletRequest request,@RequestBody Employee employee){
        String password = DigestUtils.md5DigestAsHex("123456".getBytes());
        employee.setPassword(password);
        Date date =new Date();
        employee.setUpdateTime(date);
        Long Id = (Long) request.getSession().getAttribute("employee");
        employee.setUpdateUser(Id);
        return employeeService.updateByPrimaryKeySelective(employee);
    }

    @ApiOperation("使用PageHelper分页")
    @PostMapping("/employeeListAllByPageHelper")
//    @Cacheable(value = "EmployeeCache",key = "#queryListRequest.paramsCondition.id")
    public QueryListResult<Employee> employeeListAll(@RequestBody QueryListRequest<Employee> queryListRequest) {//
        return employeeService.EmployeeList(queryListRequest);
    }
}
