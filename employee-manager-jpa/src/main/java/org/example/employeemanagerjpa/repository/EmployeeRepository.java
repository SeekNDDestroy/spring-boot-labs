package org.example.employeemanagerjpa.repository;

import org.example.employeemanagerjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
