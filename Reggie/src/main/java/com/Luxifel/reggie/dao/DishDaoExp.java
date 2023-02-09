package com.Luxifel.reggie.dao;

import com.Luxifel.reggie.mbg.dao.DishDao;
import com.Luxifel.reggie.mbg.model.Dish;
import com.Luxifel.reggie.mbg.model.Employee;
import com.Luxifel.reggie.model.DishExp;

import java.util.List;

public interface DishDaoExp extends DishDao {
    List<Dish> dishList(Long categoryId);

    DishExp dishByDishIdList(Long dishId);

    List<Dish> dishByCategoryIdList(Long categoryId);

    List<Dish> dishByNameList(String name);
}
