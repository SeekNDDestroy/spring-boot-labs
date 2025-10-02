package org.example.springsecuritydemo.rest.rest;

import org.example.springsecuritydemo.entity.Employee;
import org.example.springsecuritydemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Integer id){
        return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> findAllEmployees(){
        return ResponseEntity.ok(employeeService.getAll());
    }


    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteEmployeeById(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }
}
