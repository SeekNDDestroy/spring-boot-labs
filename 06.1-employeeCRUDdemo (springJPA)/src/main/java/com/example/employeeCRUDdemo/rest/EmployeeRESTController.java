package com.example.employeeCRUDdemo.rest;

import com.example.employeeCRUDdemo.entity.Employee;
import com.example.employeeCRUDdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {
    //quick dirty injection of employee DAO


    private EmployeeService employeeService;

    @Autowired
    public EmployeeRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployee(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        Employee employee = employeeService.findByID(id);

        if(employee == null){
            throw new RuntimeException("Employee id not found: " + id);
        }
        return employee;
    }

    //add employee POST
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }

    @DeleteMapping("/employees/delete/{deleteID}")
    public void deleteEmployee(@PathVariable int deleteID){

        Employee employee = employeeService.findByID(deleteID);

        if(employee != null){
            employeeService.deleteByID(deleteID);
            return;
        }
        throw new RuntimeException("employee id not found: " + deleteID);

    }




}
