package com.smoothstack.december.administratormicroservice.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 8259464291427304283L;

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

}
