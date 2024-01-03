package com.example.springbootProject.cruddemo.controller;

import com.example.springbootProject.cruddemo.dao.EmployeeDao;
import com.example.springbootProject.cruddemo.entity.Employees;
import com.example.springbootProject.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
       this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employees> getAllEmployees(){

        return employeeService.findAll();


    }
}
