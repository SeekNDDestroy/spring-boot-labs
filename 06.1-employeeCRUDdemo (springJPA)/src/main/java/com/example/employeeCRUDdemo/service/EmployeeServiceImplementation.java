package com.example.employeeCRUDdemo.service;

import com.example.employeeCRUDdemo.dao.EmployeeRepository;
import com.example.employeeCRUDdemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    private EmployeeRepository employeeRepository;


    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findByID(Integer id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }else{
            throw new RuntimeException("Did not find employee ID - " + id);
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);

    }

    @Override
    @Transactional
    public void deleteByID(Integer id) {
        employeeRepository.deleteById(id);
    }
}
