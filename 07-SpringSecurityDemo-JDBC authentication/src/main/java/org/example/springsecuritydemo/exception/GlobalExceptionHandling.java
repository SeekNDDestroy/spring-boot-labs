package org.example.springsecuritydemo.exception;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeNotFoundResponse> handleEmployeeNotFound(EmployeeNotFoundException e){
        EmployeeNotFoundResponse employeeNotFoundResponse = new EmployeeNotFoundResponse();
        employeeNotFoundResponse.setCode(HttpStatus.NOT_FOUND.value());
        employeeNotFoundResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(employeeNotFoundResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EmployeeNotFoundResponse> handleException(Exception e){
        EmployeeNotFoundResponse employeeNotFoundResponse = new EmployeeNotFoundResponse();
        employeeNotFoundResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        employeeNotFoundResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(employeeNotFoundResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
