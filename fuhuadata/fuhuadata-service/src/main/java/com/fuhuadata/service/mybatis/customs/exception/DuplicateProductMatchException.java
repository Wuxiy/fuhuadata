package com.fuhuadata.service.mybatis.customs.exception;

/**
 * <p>User: wangjie
 * <p>Date: 6/27/2017
 */
public class DuplicateProductMatchException extends RuntimeException {

    public DuplicateProductMatchException() {
        super();
    }

    public DuplicateProductMatchException(String message) {
        super(message);
    }

    public DuplicateProductMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateProductMatchException(Throwable cause) {
        super(cause);
    }
}
