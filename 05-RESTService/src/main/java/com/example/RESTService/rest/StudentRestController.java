package com.example.RESTService.rest;

import com.example.RESTService.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){

        students = new ArrayList<>();

        students.add(new Student("eren", "yeager"));
        students.add(new Student("mikasa", "ackerman"));
        students.add(new Student("levi", "ackerman"));
        students.add(new Student("armin", "nerd"));
    }

    //define endpoints for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    //define endpoints for "/student/{studentID}" - return a student at index

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID){
        return students.get(studentID);
    }
}
