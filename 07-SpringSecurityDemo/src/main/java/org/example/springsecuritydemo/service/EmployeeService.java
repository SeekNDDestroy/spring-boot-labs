package org.example.springsecuritydemo.service;

import org.example.springsecuritydemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee findEmployeeById(Integer id);
    List<Employee> getAll();

    Employee updateEmployee(Integer id, Employee employee);

    void deleteEmployee(Integer id);
}
