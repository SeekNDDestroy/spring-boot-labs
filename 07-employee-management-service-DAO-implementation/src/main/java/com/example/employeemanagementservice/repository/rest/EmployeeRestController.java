package com.example.employeemanagementservice.repository.rest;
import com.example.employeemanagementservice.repository.entity.Employee;
import com.example.employeemanagementservice.repository.service.EmployeeSerivce;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestController {
    private EmployeeSerivce employeeSerivce;

    public EmployeeRestController(EmployeeSerivce employeeSerivce) {
        this.employeeSerivce = employeeSerivce;
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeSerivce.saveEmployee(employee);
    }
}
