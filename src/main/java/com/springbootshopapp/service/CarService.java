package com.springbootshopapp.service;

import com.springbootshopapp.convertColor.ConvertColor;
import com.springbootshopapp.exception.CarNotExist;
import com.springbootshopapp.model.Car;
import com.springbootshopapp.model.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarServiceInter {

   private List<Car> cars;
   private ConvertColor convertColor;

   @Autowired
    public CarService(List<Car> cars, ConvertColor convertColor) {
        this.convertColor = convertColor;
        this.cars = new ArrayList<>();
        cars.add(new Car(1L,"Lamborgini","Ferano", Color.BLACK));
        cars.add(new Car(2L, "BMW","X7",Color.NAVY_BLUE));
        cars.add(new Car(3L,"Renault","Trafic",Color.RED));


    }
@Override
    public List<Car> getAll() {return  cars;}

    @Override //get
    public Optional<Car> carById(Long carId) {
       Optional<Car> findCarById = cars.stream().filter(car -> car.getCarId() == carId).findFirst();
       findCarById.orElseThrow(()-> new CarNotExist(carId));
        return findCarById;
    }

    @Override
    public List<Car> carByColor(String color) {
        return null;
    }

    @Override
    public boolean save(Car car) {
        return false;
    }

    @Override
    public boolean changeCar(Long carId, Car changedCar) {
        return false;
    }

    @Override
    public boolean changeColor(Long carId, Color color) {
        return false;
    }

    @Override
    public boolean changeMark(Long id, String newMark) {
        return false;
    }

    @Override
    public boolean removeById(Long carId) {
        return false;
    }
}
