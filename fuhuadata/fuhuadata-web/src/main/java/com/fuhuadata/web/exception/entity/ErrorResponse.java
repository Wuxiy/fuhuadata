package com.fuhuadata.web.exception.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fuhuadata.domain.query.ResultPojo;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/28/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse extends ResultPojo {

    private List<FieldErrorResponse> fieldErrors;

    public ErrorResponse(String message) {
        super(0, message);
    }

    public ErrorResponse(int code, String message) {
        super(code, message);
    }

    public List<FieldErrorResponse> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorResponse> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
