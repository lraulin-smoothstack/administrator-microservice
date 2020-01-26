package com.smoothstack.december.administratormicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class AdministratorExceptionController {
    @ExceptionHandler(value=ArgumentMissingException.class)
    public ResponseEntity<Object> exception(ArgumentMissingException exception) {
        return new ResponseEntity<>("Argument missing: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value=IllegalRelationReferenceException.class)
    public ResponseEntity<Object> exception(IllegalRelationReferenceException exception) {
        return new ResponseEntity<>("Illegal relations: " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value=ResourceAlreadyExistsException.class)
    public ResponseEntity<Object> exception(ResourceAlreadyExistsException exception) {
        return new ResponseEntity<>("Resource already exists: " + exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
