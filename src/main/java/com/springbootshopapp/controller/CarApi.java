package com.springbootshopapp.controller;

import com.springbootshopapp.convertColor.ConvertColor;
import com.springbootshopapp.model.Car;
import com.springbootshopapp.service.CarServiceInter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/api/cars", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class CarApi {
    CarServiceInter carServiceInter;
    ConvertColor convertColor;

    @Autowired
    public CarApi(CarServiceInter carServiceInter, ConvertColor convertColor) {
        this.carServiceInter = carServiceInter;
        this.convertColor = convertColor;
    }

    @ApiOperation(value = "Get all cars")
    @GetMapping
    public ResponseEntity<CollectionModel <Car>> getAllCars(){
        List<Car> carlist = carServiceInter.getAll();
        carlist.forEach(car -> car.addIf(!car.hasLinks(), ()->linkTo(CarApi.class).slash(car.getCarId()).withSelfRel()));
        Link link = linkTo(CarApi.class).withSelfRel();
        CollectionModel<Car> carResource = new CollectionModel<>(carlist,link);
        return new ResponseEntity<>(carResource,HttpStatus.OK);

    }

}
