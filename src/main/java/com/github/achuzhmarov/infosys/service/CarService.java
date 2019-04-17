package com.github.achuzhmarov.infosys.service;

import com.github.achuzhmarov.infosys.model.CarMake;
import com.github.achuzhmarov.infosys.service.api.CarApiService;
import com.github.achuzhmarov.infosys.service.mapper.CarShowsApiToCarMakeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarApiService carApiService;

    public CarService(CarApiService carApiService) {
        this.carApiService = carApiService;
    }

    public List<CarMake> getCarMakes() {
        return new CarShowsApiToCarMakeMapper().map(carApiService.getCarShows());
    }
}
