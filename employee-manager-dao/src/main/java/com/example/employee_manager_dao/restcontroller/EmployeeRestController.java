package com.example.employee_manager_dao.restcontroller;

import com.example.employee_manager_dao.entity.Employee;
import com.example.employee_manager_dao.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        Optional<Employee> updatedEmployee = employeeService.updateEmployee(id, employee);
        if(updatedEmployee.isPresent()){
            return ResponseEntity.ok(updatedEmployee.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
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

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployees =  employeeService.findAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable  int id){
        if(employeeService.deleteEmployee(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
