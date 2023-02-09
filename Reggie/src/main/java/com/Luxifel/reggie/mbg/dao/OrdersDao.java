package com.Luxifel.reggie.mbg.dao;

import com.Luxifel.reggie.mbg.model.Orders;

public interface OrdersDao {
    int deleteByPrimaryKey(Long id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}