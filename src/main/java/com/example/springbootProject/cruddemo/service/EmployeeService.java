package com.example.springbootProject.cruddemo.service;

import com.example.springbootProject.cruddemo.entity.Employees;

import java.util.List;

public interface EmployeeService {

    public List<Employees> findAll();

    public Employees findById(Integer id);

    public Employees save(Employees employees);

    public void deleteById(Integer employeeId);
}
