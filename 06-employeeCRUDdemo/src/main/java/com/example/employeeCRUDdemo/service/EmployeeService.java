package com.example.employeeCRUDdemo.service;
import com.example.employeeCRUDdemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findByID(Integer id);
    Employee save(Employee employee);
    void deleteByID(Integer id);
}
