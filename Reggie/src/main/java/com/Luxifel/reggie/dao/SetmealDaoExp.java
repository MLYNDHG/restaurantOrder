package com.Luxifel.reggie.dao;

import com.Luxifel.reggie.mbg.dao.SetmealDao;
import com.Luxifel.reggie.mbg.model.Dish;
import com.Luxifel.reggie.mbg.model.Employee;
import com.Luxifel.reggie.mbg.model.Setmeal;

import java.util.List;

public interface SetmealDaoExp extends SetmealDao {
    Setmeal selectBySetmealId(Long setmealId);

    List<Setmeal> setmealByCategoryIdList(Long categoryId);

    List<Setmeal> setmealByNameList(String name);
}
