package com.example.employeeCRUDdemo.service;

import com.example.employeeCRUDdemo.dao.EmployeeDAO;
import com.example.employeeCRUDdemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    private EmployeeDAO employeeDAO;


    public EmployeeServiceImplementation(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeDAO.findAll();
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findByID(Integer id) {
        return employeeDAO.findByID(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);

    }

    @Override
    @Transactional
    public void deleteByID(Integer id) {
        employeeDAO.deleteByID(id);
    }
}
