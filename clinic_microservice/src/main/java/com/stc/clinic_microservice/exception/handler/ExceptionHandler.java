package com.stc.clinic_microservice.exception.handler;


import com.stc.clinic_microservice.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.ParseException;

@RestControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity handleException(ParseException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e){

        return ResponseEntity.internalServerError().body(e.getMessage());
    }

}
