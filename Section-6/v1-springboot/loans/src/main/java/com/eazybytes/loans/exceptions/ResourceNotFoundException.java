package com.eazybytes.loans.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceField, String fieldName, String fieldValue){
        super(String.format("%s not found with the given input data %s: %s", resourceField, fieldName, fieldValue));
    }

}
