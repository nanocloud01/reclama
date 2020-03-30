package com.example.reclama.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ResponseError handleCustomException(final ResourceNotFoundException ex, final HttpServletRequest request) {
//        ResponseErrorImpl responseError = getResponseError(request, ex);
//        responseError.setStatus(HttpStatus.NOT_FOUND.value());
//        responseError.setError("uno");
//        return responseError;
//    }

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<Object> handleCustomException(final ResourceNotFoundException ex,
                                                        final HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ResponseErrorImpl responseError = getResponseError(request, ex);
        responseError.setStatus(HttpStatus.NOT_FOUND.value());
        responseError.setError("uno");

        //return responseError;
        return new ResponseEntity<>(responseError, status);
    }

    private ResponseErrorImpl getResponseError(HttpServletRequest request, Exception ex) {
        ResponseErrorImpl responseError = new ResponseErrorImpl();
        responseError.setTimestamp(LocalDateTime.now());
        responseError.setPath(request.getRequestURI());
        responseError.setMessage(ex.getMessage());
        return responseError;
    }

//    @ExceptionHandler(value
//            = { IllegalArgumentException.class, IllegalStateException.class })
//    protected ResponseEntity<Object> handleConflict(
//            RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "This should be application specific";
//        return handleExceptionInternal(ex, bodyOfResponse,
//                new HttpHeaders(), HttpStatus.CONFLICT, request);
//    }
}