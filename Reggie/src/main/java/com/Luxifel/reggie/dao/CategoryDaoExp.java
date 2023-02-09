package com.Luxifel.reggie.dao;

import com.Luxifel.reggie.mbg.model.Category;
import com.Luxifel.reggie.mbg.model.Employee;

import java.util.List;

public interface CategoryDaoExp {
    List<Category> categoryList();

    List<Category> categoryTypeByList(int type);
}
