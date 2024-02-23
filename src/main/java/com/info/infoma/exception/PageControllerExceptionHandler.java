package com.info.infoma.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@ControllerAdvice
public class PageControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String ExceptionHandler(Exception exception) {

        return "error/error_page";
    }
}
