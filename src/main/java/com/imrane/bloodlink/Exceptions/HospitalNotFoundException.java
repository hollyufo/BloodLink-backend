package com.imrane.bloodlink.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HospitalNotFoundException extends RuntimeException{
    public HospitalNotFoundException(Long id) {
        super("Hospital not found for id: " + id);
    }
}
