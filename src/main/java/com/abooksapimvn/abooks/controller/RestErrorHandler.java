package com.abooksapimvn.abooks.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.abooksapimvn.abooks.exception.NotFoundException;

@RestController
public class RestErrorHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<HttpStatus> handleBadRequest(DataIntegrityViolationException ex){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<HttpStatus> handleBadRequest(NotFoundException ex){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
