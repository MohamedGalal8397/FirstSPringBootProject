package com.Mohamed.SpringDataProject.bindException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class BindExceptionHandling {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleBindException(BindException exception){

        List<String> defaultError= exception.getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        return new ResponseEntity<>(defaultError, HttpStatus.BAD_REQUEST);
    }


}


