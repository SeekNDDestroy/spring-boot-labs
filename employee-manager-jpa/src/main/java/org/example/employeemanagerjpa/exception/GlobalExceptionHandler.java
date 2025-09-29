package org.example.employeemanagerjpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionResponse> employeeNotFoundException(EmployeeNotFoundException e) {

        EmployeeExceptionResponse employeeExceptionResponse = new EmployeeExceptionResponse();
        employeeExceptionResponse.setCode(HttpStatus.NOT_FOUND.value());
        employeeExceptionResponse.setMessage(e.getMessage());

        return new ResponseEntity<>(employeeExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionResponse> generalException(Exception e){
        EmployeeExceptionResponse employeeExceptionResponse = new EmployeeExceptionResponse();

        employeeExceptionResponse.setCode(HttpStatus.BAD_REQUEST.value());
        employeeExceptionResponse.setMessage(e.getMessage());

        return new ResponseEntity<>(employeeExceptionResponse, HttpStatus.BAD_REQUEST);
    }


}
