package com.smoothstack.december.administratormicroservice.exception;

import org.springframework.http.ResponseEntity;

public class ItemNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(String message) {
        super(message);
    }
}
