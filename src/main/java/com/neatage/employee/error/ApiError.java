package com.neatage.employee.error;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {

    private HttpStatus status;
    private String message;
    private String code;
    private List<String> errors;

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        this.errors = Arrays.asList(error);
    }

    public ApiError(HttpStatus status, String message, String code, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String code, String error) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
        this.errors = Arrays.asList(error);
    }
}
