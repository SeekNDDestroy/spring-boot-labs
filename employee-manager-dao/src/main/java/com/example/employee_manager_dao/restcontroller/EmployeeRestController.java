package com.example.employee_manager_dao.restcontroller;

import com.example.employee_manager_dao.entity.Employee;
import com.example.employee_manager_dao.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee){
        employeeService.registerNewEmployee(employee);
        return ResponseEntity.ok(employee);
    }
}
