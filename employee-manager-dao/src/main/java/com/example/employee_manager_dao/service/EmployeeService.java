package com.example.employee_manager_dao.service;

import com.example.employee_manager_dao.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee registerNewEmployee(Employee employee);
    Employee updateEmployeeDetails(Integer id, Employee employee) ;

    Employee findEmployeeById(Integer id);
    List<Employee> findAllEmployees();

    void deleteEmployee(int id);
}
