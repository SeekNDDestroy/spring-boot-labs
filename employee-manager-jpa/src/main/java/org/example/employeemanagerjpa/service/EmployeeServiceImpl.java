package org.example.employeemanagerjpa.service;

import jakarta.transaction.Transactional;
import org.example.employeemanagerjpa.entity.Employee;
import org.example.employeemanagerjpa.exception.EmployeeNotFoundException;
import org.example.employeemanagerjpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setId(null);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> fetchedEmployee =  employeeRepository.findById(id);
        if(fetchedEmployee.isPresent()){
            return fetchedEmployee.get();
        }
        else{
            throw new EmployeeNotFoundException("Employee with id " + id + " was not found");
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
