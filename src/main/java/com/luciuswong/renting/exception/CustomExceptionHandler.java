package com.luciuswong.renting.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        // exception handler method to be override if needed
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandler(Exception exception) {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
