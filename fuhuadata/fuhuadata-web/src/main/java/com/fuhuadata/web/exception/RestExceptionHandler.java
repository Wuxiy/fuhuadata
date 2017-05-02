package com.fuhuadata.web.exception;

import com.fuhuadata.service.util.MessageUtils;
import com.fuhuadata.web.exception.entity.ErrorResponse;
import com.fuhuadata.web.exception.entity.FieldErrorResponse;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.util.List;

/**
 * Ajax 请求时异常的处理，返回字段错误
 * <p>User: wangjie
 * <p>Date: 4/28/2017
 */
@ControllerAdvice
@Order(0)
public class RestExceptionHandler {

    Logger logger = LoggerFactory.getLogger("fuhua-error");

    @ExceptionHandler({InvalidRequestException.class})
    public ResponseEntity<Object> handleInvalidRequest(InvalidRequestException e, WebRequest webRequest) {

        if (!isAjax(webRequest)) {
            throw e;
        }

        List<FieldErrorResponse> fieldErrorResponses = Lists.newArrayList();

        List<FieldError> fieldErrors = e.getErrors().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            FieldErrorResponse fieldErrorResponse = FieldErrorResponse.from(fieldError);
            fieldErrorResponse.setMessage(MessageUtils.message(fieldError));
            fieldErrorResponses.add(fieldErrorResponse);
        }

        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        errorResponse.setFieldErrors(fieldErrorResponses);

        return handleExceptionInternal(e, errorResponse, null, HttpStatus.UNPROCESSABLE_ENTITY, webRequest);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(WebRequest request, Exception ex) throws Exception {

        if (!isAjax(request)) {
            throw ex;
        }
        logger.error(ex.getMessage(), ex);

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());

        return handleExceptionInternal(ex, errorResponse, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<Object>(body, headers, status);
    }

    private boolean isAjax(WebRequest request) {
        String requestedWithHeader = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestedWithHeader);
    }

}
