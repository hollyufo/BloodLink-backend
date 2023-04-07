package com.imrane.bloodlink.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidHospitalRequest extends RuntimeException{
    public InvalidHospitalRequest(String message) {
        super(message);
    }
}
