package com.github.achuzhmarov.infosys.service.mapper;

import com.github.achuzhmarov.infosys.model.Car;
import com.github.achuzhmarov.infosys.model.CarMake;
import com.github.achuzhmarov.infosys.service.api.model.CarShowApiModel;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Mapper for translating external model from api/v1/cars to internal application model
 */
public class CarShowsApiToCarMakeMapper {
    public List<CarMake> map(List<CarShowApiModel> carShows) {
        return carShows.stream()
                .flatMap(this::showToPlainList)
                //TODO: How empty or null models should be processed?
                .filter(elem -> elem.model != null && !elem.model.equals(""))
                //TODO: How empty or null makes should be processed?
                .filter(elem -> elem.make != null && !elem.make.equals(""))
                //TODO: How empty or null shows should be processed?
                .filter(elem -> elem.show != null && !elem.show.equals(""))
                .collect(Collectors.groupingBy(elem -> Optional.ofNullable(elem.make)))
                .entrySet().stream()
                .map(entry -> new CarMake(entry.getKey().orElse(null), parseCars(entry.getValue())))
                .sorted(Comparator.comparing(CarMake::getName))
                .collect(Collectors.toList());
    }

    private Stream<ModelShowMake> showToPlainList(CarShowApiModel show) {
        return show.getCars().stream()
                .map(car -> new ModelShowMake(
                        car.getModel(),
                        show.getName(),
                        car.getMake())
                );
    }

    private List<Car> parseCars(List<ModelShowMake> shows) {
        return shows.stream()
                //TODO: Should shows also be grouped by the same model?
                .collect(Collectors.groupingBy(elem -> Optional.ofNullable(elem.model)))
                .entrySet().stream()
                .map(entry -> new Car(entry.getKey().orElse(null), parseCarShows(entry.getValue())))
                //TODO: What sort order should cars have?
                .sorted(Comparator.comparing(Car::getModel))
                .collect(Collectors.toList());
    }

    private List<String> parseCarShows(List<ModelShowMake> carShows) {
        return carShows.stream()
                .map(elem -> elem.show)
                .distinct()
                //TODO: What sort order should shows have?
                .sorted()
                .collect(Collectors.toList());
    }

    private static class ModelShowMake {
        String model;
        String show;
        String make;

        public ModelShowMake(String model, String show, String make) {
            this.model = model;
            this.show = show;
            this.make = make;
        }
    }
}
