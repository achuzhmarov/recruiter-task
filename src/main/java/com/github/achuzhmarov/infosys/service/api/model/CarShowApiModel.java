package com.github.achuzhmarov.infosys.service.api.model;

import java.util.List;
import java.util.Objects;

/**
 * External CarShow model from api/v1/cars
 */
public class CarShowApiModel {
    private String name;
    private List<CarApiModel> cars;

    public CarShowApiModel() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarApiModel> getCars() {
        return cars;
    }

    public void setCars(List<CarApiModel> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarShowApiModel that = (CarShowApiModel) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cars);
    }

    @Override
    public String toString() {
        return "CarShowApiModel{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }
}
