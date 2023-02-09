package com.Luxifel.reggie.mbg.dao;

import com.Luxifel.reggie.mbg.model.SetmealDish;

public interface SetmealDishDao {
    int deleteByPrimaryKey(Long id);

    int insert(SetmealDish record);

    int insertSelective(SetmealDish record);

    SetmealDish selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SetmealDish record);

    int updateByPrimaryKey(SetmealDish record);
}