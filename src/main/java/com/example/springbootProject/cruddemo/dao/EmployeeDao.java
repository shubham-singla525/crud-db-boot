package com.example.springbootProject.cruddemo.dao;

import com.example.springbootProject.cruddemo.entity.Employees;

import java.util.List;

public interface EmployeeDao {

    public List<Employees> getAllEmployees();

    public Employees getEmployee(Integer id);

    public String addEmployee(Employees employees);
}
