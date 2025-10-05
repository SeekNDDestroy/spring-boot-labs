package org.example.springsecuritydemo.service;

import jakarta.transaction.Transactional;
import org.example.springsecuritydemo.entity.Employee;
import org.example.springsecuritydemo.exception.EmployeeNotFoundException;
import org.example.springsecuritydemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Optional<Employee> fetchedEmployee = employeeRepository.findById(id);
        if(fetchedEmployee.isPresent()){
            return fetchedEmployee.get();
        }
        throw new EmployeeNotFoundException("Employee with id " + id + " not found");
    }

    @Override
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee updateEmployee(Integer id, Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));

        if(employee.getFirstName() != null){
            employeeToUpdate.setFirstName(employee.getFirstName());
        }

        if(employee.getLastName() != null){
            employeeToUpdate.setLastName(employee.getLastName());
        }

        if(employee.getEmail() != null){
            employeeToUpdate.setEmail(employee.getEmail());
        }

    return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public void deleteEmployee(Integer id) {
        if(! employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException("Employee with the id " + id + " was not found");
        }
        employeeRepository.deleteById(id);
    }


}
