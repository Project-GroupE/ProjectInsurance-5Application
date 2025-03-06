package com.example.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PolicyNotActiveException extends RuntimeException {
    public PolicyNotActiveException(String message) {
        super(message);
    }
}

