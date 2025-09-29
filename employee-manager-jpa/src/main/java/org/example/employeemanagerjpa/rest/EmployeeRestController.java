package org.example.employeemanagerjpa.rest;

import org.example.employeemanagerjpa.entity.Employee;
import org.example.employeemanagerjpa.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee fetcghedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(fetcghedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        Employee fetchedEmployee =  employeeService.getEmployeeById(id);
        return ResponseEntity.ok(fetchedEmployee);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees =  employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);

    }


}
