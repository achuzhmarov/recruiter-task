package com.github.achuzhmarov.infosys.builder;

import com.github.achuzhmarov.infosys.model.Car;
import com.github.achuzhmarov.infosys.model.CarMake;
import org.assertj.core.util.Lists;

import java.util.ArrayList;

public class CarMakeBuilder {
    private CarMake carMake = new CarMake();

    public static CarMakeBuilder carMake(String name) {
        return new CarMakeBuilder()
                .name(name);
    }

    public CarMakeBuilder name(String name) {
        carMake.setName(name);
        return this;
    }

    public CarMakeBuilder addCar(String model, String... shows) {
        if (carMake.getCars() == null) {
            carMake.setCars(new ArrayList<>());
        }

        Car car = new Car();
        car.setModel(model);
        car.setShows(Lists.newArrayList(shows));
        carMake.getCars().add(car);

        return this;
    }

    public CarMake build() {
        return carMake;
    }
}
