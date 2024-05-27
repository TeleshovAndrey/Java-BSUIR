package com.example.searchjob.exception;

public class VacancyException extends RuntimeException {
    public VacancyException(Long id) {
        super("Vacancy with id=" + id + " not found");
    }
}
