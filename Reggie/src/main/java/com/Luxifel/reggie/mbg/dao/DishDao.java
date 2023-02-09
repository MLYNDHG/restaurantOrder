package com.Luxifel.reggie.mbg.dao;

import com.Luxifel.reggie.mbg.model.Dish;

public interface DishDao {
    int deleteByPrimaryKey(Long id);

    int insert(Dish record);

    int insertSelective(Dish record);

    Dish selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dish record);

    int updateByPrimaryKey(Dish record);
}