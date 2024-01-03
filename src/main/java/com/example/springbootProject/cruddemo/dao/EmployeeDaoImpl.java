package com.example.springbootProject.cruddemo.daoimpl;

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

    private EntityManager entityManager;


    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employees> getAllEmployees() {
        TypedQuery<Employees> theQuery = entityManager.createQuery(" from Employees",Employees.class);
         return theQuery.getResultList();
    }
}
