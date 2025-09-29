package com.example.JPACrud.service;

import com.example.JPACrud.entity.Employee;
import com.example.JPACrud.exception.EmployeeNotFoundException;
import com.example.JPACrud.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeByID(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new EmployeeNotFoundException("Employee with id " + id + " was not found");
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Optional<Employee> fetchedEmployee = employeeRepository.findById(id);

        if(fetchedEmployee.isPresent()){
            Employee employeeToUpdate = fetchedEmployee.get();
            employeeToUpdate.setFirstName(employee.getFirstName());
            employeeToUpdate.setLastName(employee.getLastName());
            employeeToUpdate.setDepartment(employee.getDepartment());
            return employeeRepository.save(employeeToUpdate);
        }
        else{
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }

    }

    @Override
    public void deleteEmployee(Integer id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }
        else{
            throw new EmployeeNotFoundException("Employee with id " + id + " was not found");
        }
    }


}
