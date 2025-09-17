package com.example.employeeCRUDdemo.dao;

import com.example.employeeCRUDdemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees =  query.getResultList();
        return employees;
    }

    @Override
    public Employee findByID(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        //merge -> if id = 0 insert else update
        Employee dbEmployee = entityManager.merge(employee);
        return employee;
    }

    @Override
    public void deleteByID(Integer id) {
        Employee employee1 = entityManager.find(Employee.class, id);
        entityManager.remove(employee1);
    }
}
