package com.example.employee_manager_dao.dao;

import com.example.employee_manager_dao.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }
}
