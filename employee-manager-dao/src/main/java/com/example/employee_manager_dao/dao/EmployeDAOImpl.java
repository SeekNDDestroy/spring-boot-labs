package com.example.employee_manager_dao.dao;

import com.example.employee_manager_dao.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Optional<Employee> update(Integer id, Employee employee) {
        Optional<Employee> fetchedEmployeeOptional = findById(id);
        if(fetchedEmployeeOptional.isPresent()){
            Employee fetchedEmployee = fetchedEmployeeOptional.get();
            fetchedEmployee.setId(id);
            fetchedEmployee.setFirstName(employee.getFirstName());
            fetchedEmployee.setLastName(employee.getLastName());
            fetchedEmployee.setDepartment(employee.getDepartment());
            Employee updatedEmployee = entityManager.merge(fetchedEmployee);
            return Optional.of(updatedEmployee);
        }else{
            return fetchedEmployeeOptional;
        }
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        Employee fetchedEmployee = entityManager.find(Employee.class, id);
        return Optional.ofNullable(fetchedEmployee);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee ", Employee.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("DELETE FROM Employee e WHERE e.id = : id");
        query.setParameter("id", id);
       int deletedCount =  query.executeUpdate();
    }
}
