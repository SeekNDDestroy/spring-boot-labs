package org.example.employeemanagerjpa.service;

import org.example.employeemanagerjpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployees();

    
}
