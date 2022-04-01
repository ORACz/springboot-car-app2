package com.springbootshopapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CarNotExistAdvise {

    @ResponseBody
    @ExceptionHandler(CarNotExist.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String carNotExistHandler (CarNotExist ex){
        return ex.getMessage();
    }
}
