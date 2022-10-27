package com.neatage.employee.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;

@Getter
public class NotFoundException extends ResponseStatusException {

    private final String code;

    public NotFoundException(HttpStatus status) {
        super(status);
        this.code = "REQUEST_NOT_FOUND";
    }

    public NotFoundException(HttpStatus status, String reason) {
        super(status, reason);
        this.code = "REQUEST_NOT_FOUND";
    }

    @Override
    public String getMessage() {
        return this.getReason();
    }
}
