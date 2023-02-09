package com.Luxifel.reggie.mbg.dao;

import com.Luxifel.reggie.mbg.model.Employee;

public interface EmployeeDao {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}