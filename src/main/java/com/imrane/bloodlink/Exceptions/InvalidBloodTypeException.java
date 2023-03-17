package com.imrane.bloodlink.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidBloodTypeException extends RuntimeException {
    public InvalidBloodTypeException(String message) {
        super(message);
    }
}