package com.example.JPACrud.service;

import com.example.JPACrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Employee findEmployeeByID(Integer id);
    List<Employee> getAllEmployee();

    Employee updateEmployee(Integer id, Employee employee);

    void deleteEmployee(Integer id);
}
