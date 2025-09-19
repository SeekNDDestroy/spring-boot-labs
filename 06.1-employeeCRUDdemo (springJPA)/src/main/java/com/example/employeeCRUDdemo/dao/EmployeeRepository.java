package com.example.employeeCRUDdemo.dao;

import com.example.employeeCRUDdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
