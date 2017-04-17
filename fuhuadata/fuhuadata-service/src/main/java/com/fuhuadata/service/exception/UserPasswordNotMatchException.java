package com.fuhuadata.service.exception;

/**
 * <p>User: wangjie
 * <p>Date: 4/7/2017
 */
public class UserPasswordNotMatchException extends RuntimeException {

    public UserPasswordNotMatchException() {
        super();
    }

    public UserPasswordNotMatchException(String message) {
        super(message);
    }

    public UserPasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserPasswordNotMatchException(Throwable cause) {
        super(cause);
    }
}
