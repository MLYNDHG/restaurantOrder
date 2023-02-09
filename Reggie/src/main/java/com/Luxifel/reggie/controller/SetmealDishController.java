package com.Luxifel.reggie.controller;

import com.Luxifel.reggie.mbg.model.DishFlavor;
import com.Luxifel.reggie.mbg.model.SetmealDish;
import com.Luxifel.reggie.service.DishFlavorService;
import com.Luxifel.reggie.service.SetmealDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/setmealDish")
public class SetmealDishController {
    @Autowired
    private SetmealDishService setmealDishService;

    @GetMapping("/{setmealDishId}")
    public List<SetmealDish> setmealDishBySetmealDishIdList(@PathVariable(value = "setmealDishId")  String setmealDishId) {
        return setmealDishService.setmealDishBySetmealDishIdList(setmealDishId);
    }

    @PostMapping("")
    public int insertSetmealDishId(HttpServletRequest request, @RequestBody SetmealDish setmealDish){
        Date date =new Date();
        setmealDish.setCreateTime(date);
        setmealDish.setUpdateTime(date);
        Long Id = (Long) request.getSession().getAttribute("employee");
        setmealDish.setCreateUser(Id);
        setmealDish.setUpdateUser(Id);
        return setmealDishService.insertSelective(setmealDish);
    }

    @DeleteMapping
    public int deleteBySetmealDishId(Long setmealDishId){
        return setmealDishService.deleteBySetmealDishId(setmealDishId.toString());
    }
}
