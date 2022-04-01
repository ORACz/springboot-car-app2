package com.springbootshopapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ColorNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(ColorNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String colorNotFoundHandler(ColorNotFound ex){
        return ex.getMessage();
    }
}

