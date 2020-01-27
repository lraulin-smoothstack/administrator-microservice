package com.smoothstack.december.administratormicroservice.exception;

public class ExtraneousIdException extends RuntimeException {

    private static final long serialVersionUID = 5854947426770468167L;

    public ExtraneousIdException(String message) {
        super(message);
    }

}
