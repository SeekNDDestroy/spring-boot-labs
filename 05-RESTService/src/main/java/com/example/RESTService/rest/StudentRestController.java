package com.example.RESTService.rest;

import com.example.RESTService.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        // check the student id against list size
        if(studentID >= students.size() || studentID < 0 ){
            throw new StudentNotFoundException("Student not found " + studentID);
        }

        return students.get(studentID);
    }

//    // add exception handler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
//
//        //create a studentErrorResponse
//        //return
//
//        StudentErrorResponse errorResponse = new StudentErrorResponse();
//
//        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        errorResponse.setMessage(e.getMessage());
//        errorResponse.setTime(System.currentTimeMillis());
//
//        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception e){
//
//
//        StudentErrorResponse errorResponse = new StudentErrorResponse();
//
//        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//        errorResponse.setMessage("url is not valid");
//        errorResponse.setTime(System.currentTimeMillis());
//
//        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
}
