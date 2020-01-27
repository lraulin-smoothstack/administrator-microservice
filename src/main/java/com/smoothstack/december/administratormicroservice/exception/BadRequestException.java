package com.smoothstack.december.administratormicroservice.exception;

public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 4169999993293989738L;

    public BadRequestException(String message) {
        super(message);
    }

}
