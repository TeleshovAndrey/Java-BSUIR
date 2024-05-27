package com.example.searchjob.exception;

public class EmployerException extends RuntimeException {
    public EmployerException(Long id) {
        super("Employer with id=" + id + " not found");
    }
}
