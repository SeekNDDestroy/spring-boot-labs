package com.example.employee_manager_dao.dao;

import com.example.employee_manager_dao.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    Employee save(Employee employee);

    Optional<Employee> findById(Integer id);
    List<Employee> findAll();

    void deleteById(int id);
}
