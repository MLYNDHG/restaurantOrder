package com.Luxifel.reggie.controller;

import com.Luxifel.reggie.mbg.model.Dish;
import com.Luxifel.reggie.mbg.model.DishFlavor;
import com.Luxifel.reggie.model.DishExp;
import com.Luxifel.reggie.service.DishFlavorService;
import com.Luxifel.reggie.service.DishService;
import com.Luxifel.reggie.utils.QueryListResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dishFlavor")
public class DishFlavorController {
    @Autowired
    private DishFlavorService dishFlavorService;

    @GetMapping("/{dishId}")
    public List<DishFlavor> dishFlavorByDishIdList(@PathVariable(value = "dishId")  Long dishId) {
        return dishFlavorService.dishFlavorByDishIdList(dishId);
    }

    @PostMapping("")
    public int insertDish(HttpServletRequest request, @RequestBody DishFlavor dishFlavor){
        Date date =new Date();
        dishFlavor.setCreateTime(date);
        dishFlavor.setUpdateTime(date);
        Long Id = (Long) request.getSession().getAttribute("employee");
        dishFlavor.setCreateUser(Id);
        dishFlavor.setUpdateUser(Id);
        return dishFlavorService.insertSelective(dishFlavor);
    }

    @DeleteMapping
    public int deleteByDishId(Long dishId){
        return dishFlavorService.deleteByDishId(dishId);
    }
}
