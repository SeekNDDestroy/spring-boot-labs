package com.example.employee_manager_dao.service;

import com.example.employee_manager_dao.dao.EmployeeDAO;
import com.example.employee_manager_dao.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
}
