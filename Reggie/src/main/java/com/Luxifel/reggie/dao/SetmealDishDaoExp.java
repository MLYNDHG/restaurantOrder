package com.Luxifel.reggie.dao;

import com.Luxifel.reggie.mbg.dao.SetmealDao;
import com.Luxifel.reggie.mbg.dao.SetmealDishDao;
import com.Luxifel.reggie.mbg.model.DishFlavor;
import com.Luxifel.reggie.mbg.model.SetmealDish;

import java.util.List;

public interface SetmealDishDaoExp extends SetmealDishDao {
    List<SetmealDish> setmealDishBySetmealDishIdList(String setmealId);

    int deleteBySetmealDishId(String setmealId);
}
