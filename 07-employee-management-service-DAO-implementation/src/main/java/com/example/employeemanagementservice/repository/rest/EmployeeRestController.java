package com.example.employeemanagementservice.repository.rest;
import com.example.employeemanagementservice.repository.entity.Employee;
import com.example.employeemanagementservice.repository.service.EmployeeSerivce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
    private EmployeeSerivce employeeSerivce;

    public EmployeeRestController(EmployeeSerivce employeeSerivce) {
        this.employeeSerivce = employeeSerivce;
    }

    @PostMapping()
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeSerivce.saveEmployee(employee);
    }

    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeSerivce.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        Optional<Employee> employee = employeeSerivce.findEmployeeById(id);

        if(employee.isPresent()){
            return ResponseEntity.ok(employee.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable int id){
        employeeSerivce.delete(id);
    }
}
