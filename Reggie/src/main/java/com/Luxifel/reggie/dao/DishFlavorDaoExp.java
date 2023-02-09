package com.Luxifel.reggie.dao;

import com.Luxifel.reggie.mbg.dao.DishFlavorDao;
import com.Luxifel.reggie.mbg.model.Dish;
import com.Luxifel.reggie.mbg.model.DishFlavor;

import java.util.List;

public interface DishFlavorDaoExp extends DishFlavorDao {
    List<DishFlavor> dishFlavorByDishIdList(Long categoryId);

    int deleteByDishId(Long dishId);
}
