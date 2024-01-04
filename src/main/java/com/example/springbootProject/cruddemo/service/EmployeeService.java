package com.example.springbootProject.cruddemo.service;

import com.example.springbootProject.cruddemo.entity.Employees;

import java.util.List;

public interface EmployeeService {

    List<Employees> findAll();

    Employees findById(Integer id);

    String addNewEmployee(Employees employees);

    String updateEmployee(Employees employees);

    void deleteEmployee(Integer employeeId);
}
