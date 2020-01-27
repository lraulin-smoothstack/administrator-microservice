package com.smoothstack.december.administratormicroservice.exception;

public class ExtraneousIdException extends RuntimeException {

    private static final long serialVersionUID = 1337L;

    public ExtraneousIdException(String message) {
        super(message);
    }

}
