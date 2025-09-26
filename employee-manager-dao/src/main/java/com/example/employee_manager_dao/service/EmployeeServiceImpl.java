package com.example.employee_manager_dao.service;

import com.example.employee_manager_dao.dao.EmployeeDAO;
import com.example.employee_manager_dao.entity.Employee;
import com.example.employee_manager_dao.exception.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }



    @Override
    public Employee registerNewEmployee(Employee employee) {
        employee.setId(null);
        return employeeDAO.save(employee);
    }

    @Override
    public Employee updateEmployeeDetails(Integer id, Employee employee) {
        Optional<Employee> existingEmployee = employeeDAO.findById(id);
        if(existingEmployee.isPresent()){
            employee.setId(id);
            return employeeDAO.save(employee);
        }else{
            throw new EmployeeNotFoundException("employee with id " + id + " not found, no uptake took place");
        }
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Optional<Employee> fetchedEmployee = employeeDAO.findById(id);
        if(fetchedEmployee.isPresent()){
            return fetchedEmployee.get();
        }
        else{
            throw new EmployeeNotFoundException("employee with id " + id + " not found");
        }
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteById(id);
    }
}
