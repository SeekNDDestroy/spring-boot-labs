package org.example.springsecuritydemo.exception;

public class EmployeeNotFoundResponse {
    private String message;
    private int code;

    public EmployeeNotFoundResponse() {
    }

    public EmployeeNotFoundResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
