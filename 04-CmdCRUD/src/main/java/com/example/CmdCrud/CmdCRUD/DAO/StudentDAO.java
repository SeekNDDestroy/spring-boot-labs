package com.example.CmdCrud.CmdCRUD.DAO;

import com.example.CmdCrud.CmdCRUD.Entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    List<Student> getAll();
    Student findByFirstName(String firstName);



    Student getById(Integer id);


    int deleteAll();
    int deleteById(Integer id);

    void update(Student student);


}
