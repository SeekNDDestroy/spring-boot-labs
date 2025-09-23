package com.example.employeemanagementservice.repository.service;

import com.example.employeemanagementservice.repository.dao.EmployeeDAO;
import com.example.employeemanagementservice.repository.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements  EmployeeSerivce{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Optional<Employee> findEmployeeById(Integer id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
       return employeeDAO.getAll();
    }

    @Override
    public void delete(Integer id) {
        employeeDAO.delete(id);
    }

    @Override
    public Employee update(Integer id, Employee employee) {
        return employeeDAO.update(id, employee);
    }
}
