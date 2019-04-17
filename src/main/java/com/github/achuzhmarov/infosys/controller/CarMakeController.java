package com.github.achuzhmarov.infosys.controller;

import com.github.achuzhmarov.infosys.model.Car;
import com.github.achuzhmarov.infosys.model.CarMake;
import com.github.achuzhmarov.infosys.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car_makes")
public class CarMakeController {
    private final CarService carService;

    public CarMakeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    //dummy controller method to print results to System.out in the task format
    public void printCarMakes() {
        List<CarMake> carMakes = carService.getCarMakes();
        carMakes.forEach(make -> printCarMake(make));
    }

    private void printCarMake(CarMake carMake) {
        System.out.printf("%s%n", carMake.getName());
        carMake.getCars().forEach(this::printCar);
    }

    private void printCar(Car car) {
        System.out.printf("     %s%n", car.getModel());
        car.getShows().forEach(show -> System.out.printf("          %s%n", show));
    }

    @GetMapping("/json")
    //return mapped result as json
    public List<CarMake> getCarMakesJson() {
        return carService.getCarMakes();
    }
}