package com.example.CmdCrud.CmdCRUD.DAO;

import com.example.CmdCrud.CmdCRUD.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO{

    private EntityManager entityManager;

    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findByFirstName(String firstName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where firstName = :firstName", Student.class);
        query.setParameter("firstName", firstName);
        return query.getSingleResult();
    }

    @Override
    public Student getById(Integer id) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE id=:id", Student.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student")
                .executeUpdate();
    }

    @Override
    @Transactional
    public int deleteById(Integer id) {
        return entityManager.createQuery("delete from Student  where id = :studentid")
                .setParameter("studentid", id)
                .executeUpdate();

    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }


}
