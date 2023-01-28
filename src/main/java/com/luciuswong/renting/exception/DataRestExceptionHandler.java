package com.luciuswong.renting.exception;

import org.springframework.data.rest.webmvc.RepositoryRestExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice(basePackageClasses = RepositoryRestExceptionHandler.class)
public class DataRestExceptionHandler extends CustomExceptionHandler {
}
