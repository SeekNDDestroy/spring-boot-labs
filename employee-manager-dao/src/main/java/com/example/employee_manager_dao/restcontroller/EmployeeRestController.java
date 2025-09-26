package com.example.employee_manager_dao.restcontroller;

import com.example.employee_manager_dao.entity.Employee;
import com.example.employee_manager_dao.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.registerNewEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        Employee updatedEmployee =  employeeService.updateEmployeeDetails(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        Employee fetchedEmplyee =  employeeService.findEmployeeById(id);
        return ResponseEntity.ok(fetchedEmplyee);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployees =  employeeService.findAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable  int id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
