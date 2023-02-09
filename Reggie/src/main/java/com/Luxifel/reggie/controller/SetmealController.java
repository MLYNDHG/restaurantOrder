package com.Luxifel.reggie.controller;

import com.Luxifel.reggie.exception.MyException;
import com.Luxifel.reggie.mbg.model.Dish;
import com.Luxifel.reggie.mbg.model.DishFlavor;
import com.Luxifel.reggie.mbg.model.Setmeal;
import com.Luxifel.reggie.mbg.model.SetmealDish;
import com.Luxifel.reggie.model.DishExp;
import com.Luxifel.reggie.model.SetmealExp;
import com.Luxifel.reggie.service.DishFlavorService;
import com.Luxifel.reggie.service.DishService;
import com.Luxifel.reggie.service.SetmealDishService;
import com.Luxifel.reggie.service.SetmealService;
import com.Luxifel.reggie.utils.QueryListRequest;
import com.Luxifel.reggie.utils.QueryListResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private SetmealDishService setmealDishService;

    @PostMapping("/page")
    public QueryListResult<SetmealExp> setmealByNameList(@RequestBody QueryListRequest<Setmeal> queryListRequest) {
        return setmealService.setmealByNameList(queryListRequest);
    }

    @GetMapping("/{setmealId}")
    public SetmealExp setmealByCategoryIdList(@PathVariable(value = "setmealId")  Long setmealId) {
        List<SetmealDish> list = new ArrayList<>();
        list = setmealDishService.setmealDishBySetmealDishIdList(setmealId.toString());
        SetmealExp setmealExp = setmealService.setmealBySetmealIdList(setmealId);
        setmealExp.setSetmealDishes(list);
        return setmealExp;
    }
    @PostMapping("")
    public String insertSetmeal(HttpServletRequest request, @RequestBody SetmealExp setmealExp){
        if(setmealService.checkNameExits(setmealExp.getName()).size()>0){
            throw new MyException("该菜品已存在、请勿重复添加");
        }
        Date date =new Date();
        setmealExp.setCreateTime(date);
        setmealExp.setUpdateTime(date);
        Long Id = (Long) request.getSession().getAttribute("employee");
        setmealExp.setCreateUser(Id);
        setmealExp.setUpdateUser(Id);
        setmealService.insertSelective(setmealExp);
        List<SetmealDish> list = setmealExp.getSetmealDishes();
        if(list !=null && list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setSetmealId(setmealExp.getId().toString());
                list.get(i).setCreateTime(date);
                list.get(i).setUpdateTime(date);
                list.get(i).setCreateUser(Id);
                list.get(i).setUpdateUser(Id);
                setmealDishService.insertSelective(list.get(i));
            }
        }
        return "添加成功";
    }

    @PutMapping("")
    public int editSetmeal(HttpServletRequest request,@RequestBody SetmealExp setmealExp){
        Date date =new Date();
        setmealExp.setCreateTime(date);
        setmealExp.setUpdateTime(date);
        Long Id = (Long) request.getSession().getAttribute("employee");
        setmealExp.setCreateUser(Id);
        setmealExp.setUpdateUser(Id);
        //把对应菜品的风味删除  再对此菜品添加新风味
        setmealDishService.deleteBySetmealDishId(setmealExp.getId().toString());
        //修改菜品信息
        List<SetmealDish> list = setmealExp.getSetmealDishes();
        if(list !=null && list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setSetmealId(setmealExp.toString());
                list.get(i).setCreateTime(date);
                list.get(i).setUpdateTime(date);
                list.get(i).setCreateUser(Id);
                list.get(i).setUpdateUser(Id);
                setmealDishService.insertSelective(list.get(i));
            }
        }

        return setmealService.updateByPrimaryKeySelective(setmealExp);
    }
    @DeleteMapping
    public String deleteDish(String ids){
        if (StringUtils.isEmpty(ids.trim())) {
            throw new MyException("批量操作，请先勾选操作菜品！");
        }
        String[] split = ids.trim().split(",");
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            setmealDishService.deleteBySetmealDishId(split[i]);
            setmealService.deleteByPrimaryKey(Long.parseLong(split[i]));
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
            SetmealExp setmealExp = new SetmealExp();
            setmealExp.setStatus(status);
            setmealExp.setId(Long.parseLong(split[i]));
            setmealService.updateByPrimaryKeySelective(setmealExp);
        }
        return status == 0 ? "停售成功":"起售成功";
    }
}
