package com.example.employee_manager_dao.restcontroller;

import com.example.employee_manager_dao.entity.Employee;
import com.example.employee_manager_dao.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.registerNewEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        Optional<Employee> fetchedEmplyee =  employeeService.findEmployeeById(id);
        if(fetchedEmplyee.isPresent()){
            return ResponseEntity.ok(fetchedEmplyee.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
