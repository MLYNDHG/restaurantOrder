package com.Luxifel.reggie.service;

import com.Luxifel.reggie.dao.EmployeeDaoExp;
import com.Luxifel.reggie.mbg.dao.EmployeeDao;
import com.Luxifel.reggie.mbg.model.Employee;
import com.Luxifel.reggie.utils.QueryListRequest;
import com.Luxifel.reggie.utils.QueryListResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private EmployeeDaoExp employeeDaoExp;

    public Employee selectByEmployeeName(String EmployeeName){
        return employeeDaoExp.selectByEmployeeName(EmployeeName);
    }

    public Employee selectByPrimaryKey(Long id){
        return employeeDao.selectByPrimaryKey(id);
    }

    public int insertSelective(Employee employee){
        return employeeDao.insertSelective(employee);
    }

    public int updateByPrimaryKeySelective(Employee employee){
        return employeeDao.updateByPrimaryKeySelective(employee);
    }


    public QueryListResult<Employee> EmployeeList(QueryListRequest<Employee> queryListRequest){
        try{
            Page page = PageHelper.startPage(queryListRequest.getPageCondition().getPageNo(), queryListRequest.getPageCondition().getPageSize());
            employeeDaoExp.EmployeeList(queryListRequest.getParamsCondition().getName());
            return new QueryListResult<>(page);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional(noRollbackFor = {RuntimeException.class})
    public int selectByPrimaryKey(Employee employee){
        try{
            return employeeDao.insert(employee);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
