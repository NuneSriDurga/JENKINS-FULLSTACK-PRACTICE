package com.klef.service;

import java.util.List;
import com.klef.entity.Car;

public interface CarService {
    Car addCar(Car car);
    List<Car> getAllCars();
    Car getCarById(Long id);
    Car updateCar(Car car);
    void deleteCarById(Long id);
}
