package com.fuhuadata.web.exception;

import org.springframework.validation.Errors;

/**
 * <p>User: wangjie
 * <p>Date: 4/28/2017
 */
public class InvalidRequestException extends RuntimeException {

    private Errors errors;

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return this.errors;
    }
}
