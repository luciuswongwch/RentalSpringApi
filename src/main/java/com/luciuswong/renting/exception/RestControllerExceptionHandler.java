package com.luciuswong.renting.exception;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class RestControllerExceptionHandler extends CustomExceptionHandler {
}
