package com.Luxifel.reggie.dao;

import com.Luxifel.reggie.mbg.model.Employee;

import java.util.List;

public interface EmployeeDaoExp {
    Employee selectByEmployeeName(String EmployeeName);

    List<Employee> EmployeeList(String name);
}
