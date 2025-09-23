package com.example.employeemanagementservice.repository.dao;

import com.example.employeemanagementservice.repository.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    Employee save(Employee employee);
    Optional<Employee> findById(Integer id);
    List<Employee> getAll();
    void delete(Integer id);
    Employee update(Employee employee);
}
