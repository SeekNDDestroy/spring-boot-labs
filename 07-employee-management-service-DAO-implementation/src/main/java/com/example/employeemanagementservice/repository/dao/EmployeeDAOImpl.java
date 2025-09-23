package com.example.employeemanagementservice.repository.dao;

import com.example.employeemanagementservice.repository.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        return Optional.ofNullable(employee);
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public void delete(Integer id) {
        Optional<Employee> employee = findById(id);
        Employee deleteEmployee = employee.orElseThrow(()-> new RuntimeException("not found"));
        entityManager.remove(deleteEmployee);
    }

    @Override
    public Employee update(Integer id, Employee employee) {
        Employee existingEmployee = findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found " + id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        return save(existingEmployee);
    }
}
