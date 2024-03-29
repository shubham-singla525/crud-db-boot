package com.example.springbootProject.cruddemo.service;

import com.example.springbootProject.cruddemo.dao.EmployeeDao;
import com.example.springbootProject.cruddemo.entity.Employees;
import com.example.springbootProject.cruddemo.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //our service name is employee-to fetch employee information

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    // find all employees
    @Override
    public List<Employees> findAll() {
        return employeeDao.findAll();
    }

    //find employee by id
    @Override
    public Employees findById(Integer id) {
        return  employeeDao.findById(id);
    }

    // save employee
    @Transactional
    @Override
    public Employees save(Employees employees) {
        return employeeDao.save(employees);
    }


    // delete employee
    @Transactional
    @Override
    public void deleteById(Integer employeeId) {
        employeeDao.deleteById(employeeId);
    }
}
