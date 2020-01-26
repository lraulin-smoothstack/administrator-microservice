package com.smoothstack.december.administratormicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class AdministratorExceptionController {
    @ExceptionHandler(value=ArgumentMissingException.class)
    public ResponseEntity<Object> exception(ArgumentMissingException exception) {
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value=IllegalRelationReferenceException.class)
    public ResponseEntity<Object> exception(IllegalRelationReferenceException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value=ResourceAlreadyExistsException.class)
    public ResponseEntity<Object> exception(ResourceAlreadyExistsException exception) {
        return new ResponseEntity<>(exception, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
