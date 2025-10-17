package com.klef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.klef.entity.Car;
import com.klef.service.CarService;

@RestController
@RequestMapping("/carapi")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car savedCar = carService.addCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        if (car != null) return new ResponseEntity<>(car, HttpStatus.OK);
        else return new ResponseEntity<>("Car with ID " + id + " not found.", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCar(@RequestBody Car car) {
        Car existing = carService.getCarById(car.getId());
        if (existing != null) {
            Car updated = carService.updateCar(car);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot update. Car with ID " + car.getId() + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        Car existing = carService.getCarById(id);
        if (existing != null) {
            carService.deleteCarById(id);
            return new ResponseEntity<>("Car with ID " + id + " deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot delete. Car with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
