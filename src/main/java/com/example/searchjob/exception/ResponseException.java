package com.example.searchjob.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseException {
    private int statusCode;
    private String message;

    public ResponseException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
