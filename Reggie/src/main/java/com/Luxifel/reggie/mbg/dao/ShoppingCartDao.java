package com.Luxifel.reggie.mbg.dao;

import com.Luxifel.reggie.mbg.model.ShoppingCart;

public interface ShoppingCartDao {
    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}