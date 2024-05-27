package com.example.searchjob.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ NoHandlerFoundException.class,
                        VacancyException.class,
                        EmployerException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseException handleNoHandlerFoundException(NoHandlerFoundException e) {
        log.error("ERROR 404 - " + e.getMessage());
        return new ResponseException(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseException handleMethodNotAllowedException(Exception e) {
        log.error("ERROR 405 - " + e.getMessage());
        return new ResponseException(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseException handleInternalServerErrorException(RuntimeException e) {
        log.error("ERROR 500 - " + e.getMessage());
        return new ResponseException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler({HttpClientErrorException.class, HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class, MissingServletRequestParameterException.class,
            ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseException handleBadRequestException(Exception e) {
        log.error("ERROR 400 - Bad request");
        return new ResponseException(HttpStatus.BAD_REQUEST.value(), "Bad request");
    }
}

// NoHandlerFoundException - если не найден обработчик исключений
// HttpClientErrorException - запрос задан нееоректно
// HttpMessageNotReadableException
// ConstraintViolationException
// MethodArgumentNotValidException
// ConstraintViolationException
// RuntimeException - в двнном