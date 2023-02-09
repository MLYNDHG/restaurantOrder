package com.Luxifel.reggie.mbg.dao;

import com.Luxifel.reggie.mbg.model.OrderDetail;

public interface OrderDetailDao {
    int deleteByPrimaryKey(Long id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}