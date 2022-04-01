package com.springbootshopapp.exception;
public class CarNotExist extends RuntimeException {

    public CarNotExist(Long id) {
        super(String.format("Car with given id: %s not exist", id));
    }
}

