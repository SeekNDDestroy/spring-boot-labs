package com.example.employeemanagementservice.repository.rest;
import com.example.employeemanagementservice.repository.entity.Employee;
import com.example.employeemanagementservice.repository.service.EmployeeSerivce;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
    private EmployeeSerivce employeeSerivce;

    public EmployeeRestController(EmployeeSerivce employeeSerivce) {
        this.employeeSerivce = employeeSerivce;
    }

    @PostMapping()
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeSerivce.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeSerivce.findEmployeeById(id)
                .orElseThrow(()-> new RuntimeException("employee not found"));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable int id){
        employeeSerivce.delete(id);
    }
}
