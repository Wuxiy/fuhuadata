package com.fuhuadata.service.exception;

/**
 * <p>User: wangjie
 * <p>Date: 4/7/2017
 */
public class UserNotExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotExistsException() {
        super();
    }

    public UserNotExistsException(String message) {
        super(message);
    }

    public UserNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotExistsException(Throwable cause) {
        super(cause);
    }
}
