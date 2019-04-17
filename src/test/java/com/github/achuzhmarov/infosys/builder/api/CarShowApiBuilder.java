package com.github.achuzhmarov.infosys.builder.api;

import com.github.achuzhmarov.infosys.service.api.model.CarApiModel;
import com.github.achuzhmarov.infosys.service.api.model.CarShowApiModel;

import java.util.ArrayList;

public class CarShowApiBuilder {
    private CarShowApiModel show = new CarShowApiModel();

    public static CarShowApiBuilder carShow(String name) {
        return new CarShowApiBuilder()
                .name(name);
    }

    public CarShowApiBuilder name(String name) {
        show.setName(name);
        return this;
    }

    public CarShowApiBuilder addCar(String make, String model) {
        if (show.getCars() == null) {
            show.setCars(new ArrayList<>());
        }

        show.getCars().add(new CarApiModel(make, model));
        return this;
    }

    public CarShowApiModel build() {
        return show;
    }
}
