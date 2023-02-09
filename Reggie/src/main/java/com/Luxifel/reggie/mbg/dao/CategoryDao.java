package com.Luxifel.reggie.mbg.dao;

import com.Luxifel.reggie.mbg.model.Category;

public interface CategoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}