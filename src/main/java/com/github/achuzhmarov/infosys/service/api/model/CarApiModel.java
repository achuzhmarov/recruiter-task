package com.github.achuzhmarov.infosys.service.api.model;

import java.util.Objects;

/**
 * External Car model from api/v1/cars
 */
public class CarApiModel {
    private String make;
    private String model;

    public CarApiModel() { }

    public CarApiModel(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarApiModel that = (CarApiModel) o;
        return Objects.equals(make, that.make) &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model);
    }

    @Override
    public String toString() {
        return "CarApiModel{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
