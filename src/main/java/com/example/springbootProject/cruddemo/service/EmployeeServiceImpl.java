package com.example.springbootProject.cruddemo.serviceimpl;

import com.example.springbootProject.cruddemo.dao.EmployeeDao;
import com.example.springbootProject.cruddemo.entity.Employees;
import com.example.springbootProject.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //our service name is employee-to fetch employee information

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employees> findAll() {
        return employeeDao.getAllEmployees();
    }
}
