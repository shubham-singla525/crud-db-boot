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
        Employees employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id not found: "+ employeeId);
        }

        return employee;
    }

    //create employee
    @PostMapping("/employee")
    public Employees addEmployee(@RequestBody Employees employee){
        // make id of employee to 0 because for id = 0 merge create new entry
        employee.setId(0);

        return employeeService.save(employee);
    }

    // update employee
    @PutMapping("/employee")
    public Employees updateEmployee(@RequestBody Employees employee){

        return employeeService.save(employee);
    }

    //delete employee
    @DeleteMapping("/employee/{employeeId}")
    public String removeEmployeeDetails(@PathVariable Integer employeeId){

        Employees employee = employeeService.findById(employeeId);

        if(employee==null){
            throw new RuntimeException("Employee id not found: "+ employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id: "+ employeeId;
    }
}
