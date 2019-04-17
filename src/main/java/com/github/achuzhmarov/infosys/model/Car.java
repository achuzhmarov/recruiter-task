package com.github.achuzhmarov.infosys.model;

import java.util.List;
import java.util.Objects;

public class Car {
    private String model;
    private List<String> shows;

    public Car() {}

    public Car(String model, List<String> shows) {
        this.model = model;
        this.shows = shows;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<String> getShows() {
        return shows;
    }

    public void setShows(List<String> shows) {
        this.shows = shows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) &&
                Objects.equals(shows, car.shows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, shows);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", shows=" + shows +
                '}';
    }
}
