package com.example.springbootProject.cruddemo.dao;

import com.example.springbootProject.cruddemo.entity.Employees;

import java.util.List;

public interface EmployeeDao {

    public List<Employees> findAll();

    public Employees findById(Integer id);

    public Employees save(Employees employees);

    public void deleteById(Integer employeeId);
}
