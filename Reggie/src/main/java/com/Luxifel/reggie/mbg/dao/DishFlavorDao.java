package com.Luxifel.reggie.mbg.dao;

import com.Luxifel.reggie.mbg.model.DishFlavor;

public interface DishFlavorDao {
    int deleteByPrimaryKey(Long id);

    int insert(DishFlavor record);

    int insertSelective(DishFlavor record);

    DishFlavor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DishFlavor record);

    int updateByPrimaryKey(DishFlavor record);
}