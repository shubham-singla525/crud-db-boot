package com.example.springbootProject.cruddemo.controller;

import com.example.springbootProject.cruddemo.dao.EmployeeDao;
import com.example.springbootProject.cruddemo.entity.Employees;
import com.example.springbootProject.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
       this.employeeService = employeeService;
    }

    // retrives all employees
    @GetMapping("/employee")
    public List<Employees> getAllEmployees(){

        return employeeService.findAll();
    }

    //retrieve employee by id
    @GetMapping("/employee/{employeeId}")
    public Employees getEmployeeById(@PathVariable  int employeeId){
        return employeeService.findById(employeeId);
    }

    //add employee
    @PostMapping("/employee/add")
    public String addEmployee(@PathVariable  String firstName, @PathVariable  String lastName,@PathVariable  String email){
        Employees employee = new Employees(firstName,lastName,email);
        return employeeService.addNewEmployee(employee);
    }
}
