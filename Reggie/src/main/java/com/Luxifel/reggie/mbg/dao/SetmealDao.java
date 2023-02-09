package com.Luxifel.reggie.mbg.dao;

import com.Luxifel.reggie.mbg.model.Setmeal;

public interface SetmealDao {
    int deleteByPrimaryKey(Long id);

    int insert(Setmeal record);

    int insertSelective(Setmeal record);

    Setmeal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Setmeal record);

    int updateByPrimaryKey(Setmeal record);
}