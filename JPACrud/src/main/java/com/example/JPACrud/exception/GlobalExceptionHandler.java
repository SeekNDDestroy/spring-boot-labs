package com.example.JPACrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeNotFoundExceptionResponse> handleException(EmployeeNotFoundException e){
        EmployeeNotFoundExceptionResponse employeeNotFoundExceptionResponse = new EmployeeNotFoundExceptionResponse();

        employeeNotFoundExceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
        employeeNotFoundExceptionResponse.setMessage(e.getMessage());

        return new ResponseEntity<>(employeeNotFoundExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeNotFoundExceptionResponse> handleException(Exception e){
        EmployeeNotFoundExceptionResponse employeeNotFoundExceptionResponse = new EmployeeNotFoundExceptionResponse();

        employeeNotFoundExceptionResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeNotFoundExceptionResponse.setMessage(e.getMessage());

        return new ResponseEntity<>(employeeNotFoundExceptionResponse, HttpStatus.BAD_REQUEST);


    }
}
