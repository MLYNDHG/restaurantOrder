package com.Luxifel.reggie.controller;

import com.Luxifel.reggie.exception.MyException;
import com.Luxifel.reggie.mbg.model.Category;
import com.Luxifel.reggie.mbg.model.Dish;
import com.Luxifel.reggie.mbg.model.DishFlavor;
import com.Luxifel.reggie.model.DishExp;
import com.Luxifel.reggie.service.CategoryService;
import com.Luxifel.reggie.service.DishFlavorService;
import com.Luxifel.reggie.service.DishService;
import com.Luxifel.reggie.utils.QueryListRequest;
import com.Luxifel.reggie.utils.QueryListResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;

    @PostMapping("/page")
    public QueryListResult<DishExp> dishByNameList(@RequestBody QueryListRequest<Dish> queryListRequest) {
        return dishService.dishByNameList(queryListRequest);
    }

    @GetMapping("/{dishId}")
    public DishExp dishByDishIdList(@PathVariable(value = "dishId")  Long dishId) {
        List<DishFlavor> list = new ArrayList<>();
        list = dishFlavorService.dishFlavorByDishIdList(dishId);
        DishExp dishExp = dishService.dishByDishIdList(dishId);
        dishExp.setFlavors(list);
        return dishExp;
    }

    @GetMapping("/list/{categoryId}")
    public QueryListResult<Dish> dishByCategoryIdList(@PathVariable Long categoryId) {
        return dishService.dishByCategoryIdList(categoryId);
    }

    @PostMapping("")
    public String insertDish(HttpServletRequest request, @RequestBody DishExp dishExp){
        if(dishService.checkNameExits(dishExp.getName()).size()>0){
            throw new MyException("该菜品已存在、请勿重复添加");
        }
        Date date =new Date();
        dishExp.setCreateTime(date);
        dishExp.setUpdateTime(date);
        Long Id = (Long) request.getSession().getAttribute("employee");
        dishExp.setCreateUser(Id);
        dishExp.setUpdateUser(Id);
        dishService.insertSelective(dishExp);
        List<DishFlavor> list = dishExp.getFlavors();
        if(list !=null && list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setDishId(dishExp.getId());
                list.get(i).setCreateTime(date);
                list.get(i).setUpdateTime(date);
                list.get(i).setCreateUser(Id);
                list.get(i).setUpdateUser(Id);
                dishFlavorService.insertSelective(list.get(i));
            }
        }
        return "添加成功";
    }

    @PutMapping("")
    public int editDish(HttpServletRequest request,@RequestBody DishExp dishExp){
        Date date =new Date();
        dishExp.setCreateTime(date);
        dishExp.setUpdateTime(date);
        Long Id = (Long) request.getSession().getAttribute("employee");
        dishExp.setCreateUser(Id);
        dishExp.setUpdateUser(Id);
        //把对应菜品的风味删除  再对此菜品添加新风味
        dishFlavorService.deleteByDishId(dishExp.getId());
        //修改菜品信息
        List<DishFlavor> list = dishExp.getFlavors();
        if(list !=null && list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setDishId(dishExp.getId());
                list.get(i).setCreateTime(date);
                list.get(i).setUpdateTime(date);
                list.get(i).setCreateUser(Id);
                list.get(i).setUpdateUser(Id);
                dishFlavorService.insertSelective(list.get(i));
            }
        }

        return dishService.updateByPrimaryKeySelective(dishExp);
    }

    @DeleteMapping
    public String deleteDish(String ids){
        if (StringUtils.isEmpty(ids.trim())) {
            throw new MyException("批量操作，请先勾选操作菜品！");
        }
        String[] split = ids.trim().split(",");
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            dishFlavorService.deleteByDishId(Long.parseLong(split[i]));
            dishService.deleteByPrimaryKey(Long.parseLong(split[i]));
        }
        return "删除成功";
    }

    @PostMapping("/status/{status}")
    public String changeStatus(@PathVariable int status,String ids){
        if (StringUtils.isEmpty(ids.trim())) {
            throw new MyException("批量操作，请先勾选操作菜品！");
        }
        String[] split = ids.trim().split(",");
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            DishExp dishExp = new DishExp();
            dishExp.setStatus(status);
            dishExp.setId(Long.parseLong(split[i]));
            dishService.updateByPrimaryKeySelective(dishExp);
        }
        return status == 0 ? "停售成功":"起售成功";
    }
}
