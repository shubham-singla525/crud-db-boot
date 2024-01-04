package com.example.springbootProject.cruddemo.dao;

import com.example.springbootProject.cruddemo.dao.EmployeeDao;
import com.example.springbootProject.cruddemo.entity.Employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    //creating entity manager object
    private EntityManager entityManager;

    // initiliasing entity manager object using constructor injection
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // retrieve data of all employees
    @Override
    public List<Employees> getAllEmployees() {
        TypedQuery<Employees> theQuery = entityManager.createQuery(" from Employees",Employees.class);
         return theQuery.getResultList();
    }

    // retrieve data of one employee
    @Override
    public Employees getEmployee(Integer id) {
        Employees employee = entityManager.find(Employees.class, id);

        return employee;
    }

    @Transactional
    // add data into database
    public String addEmployee(Employees employees){
        entityManager.persist(employees);

        return "Employee added successfully!!!";
    }


    //update employee data
    @Override
    public String updateEmployee(Employees employees) {
        return null;
    }


    //delete employee data
    @Override
    public void deleteEmployee(Integer employeeId) {
       Employees employee =  entityManager.find(Employees.class,employeeId);
       if(employee!=null){
           entityManager.remove(employee);
       }

    }


}
