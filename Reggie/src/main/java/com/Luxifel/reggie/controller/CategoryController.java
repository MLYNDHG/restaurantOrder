package com.Luxifel.reggie.controller;

import com.Luxifel.reggie.exception.MyException;
import com.Luxifel.reggie.mbg.model.Category;
import com.Luxifel.reggie.mbg.model.Employee;
import com.Luxifel.reggie.service.CategoryService;
import com.Luxifel.reggie.service.DishService;
import com.Luxifel.reggie.service.SetmealService;
import com.Luxifel.reggie.utils.QueryListRequest;
import com.Luxifel.reggie.utils.QueryListResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private DishService dishService;

    @PostMapping("/page")
    public QueryListResult<Category> categoryList(@RequestBody QueryListRequest<Category> queryListRequest) {
        return categoryService.categoryList(queryListRequest);
    }

    @GetMapping("/list/{type}")
    public List<Category> categoryTypeByList(@PathVariable int type) {
        return categoryService.categoryTypeByList(type);
    }

    @PostMapping("")
    public int insertCategory(HttpServletRequest request, @RequestBody Category category){
        Date date =new Date();
        category.setCreateTime(date);
        category.setUpdateTime(date);
        Long Id = (Long) request.getSession().getAttribute("employee");
        category.setCreateUser(Id);
        category.setUpdateUser(Id);
        return categoryService.insertSelective(category);
    }

    @PutMapping("")
    public int editCategory(HttpServletRequest request,@RequestBody Category category){
        Date date =new Date();
        category.setUpdateTime(date);
        Long Id = (Long) request.getSession().getAttribute("employee");
        category.setUpdateUser(Id);
        return categoryService.updateByPrimaryKeySelective(category);
    }

    @DeleteMapping
    public int deleteCategory(Long id){
        if( dishService.dishByCategoryIdList(id).getResultList().size() != 0){
            throw new MyException("菜单含有相应的菜品，不可删除");
        }
        if( setmealService.setmealByCategoryIdList(id).getResultList().size() != 0){
            throw new MyException("菜单含有相应的套餐，不可删除");
        }
        return categoryService.deleteByPrimaryKey(id);
    }
}
