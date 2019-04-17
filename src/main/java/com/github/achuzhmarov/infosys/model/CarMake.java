package com.github.achuzhmarov.infosys.model;

import java.util.List;
import java.util.Objects;

public class CarMake {
    private String name;
    private List<Car> cars;

    public CarMake() { }

    public CarMake(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMake carMake = (CarMake) o;
        return Objects.equals(name, carMake.name) &&
                Objects.equals(cars, carMake.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cars);
    }

    @Override
    public String toString() {
        return "CarMake{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }
}
