package com.example.employee_manager_dao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException e){
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception e){
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();

        employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeErrorResponse.setMessage(e.getMessage());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
