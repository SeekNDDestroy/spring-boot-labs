package com.example.employeemanagementservice.repository.service;

import com.example.employeemanagementservice.repository.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeSerivce {
    Employee saveEmployee(Employee employee);
    Optional<Employee> findEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    void delete(Integer id);
    Employee update(Integer id, Employee employee);
}
