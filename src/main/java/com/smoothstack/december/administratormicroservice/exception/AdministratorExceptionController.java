package com.smoothstack.december.administratormicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class AdministratorExceptionController {
    @ExceptionHandler(value=ArgumentMissingException.class)
    public ResponseEntity<Object> exception(ArgumentMissingException exception) {
        return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
    }
}
