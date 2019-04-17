package com.github.achuzhmarov.infosys.service.api;

import com.github.achuzhmarov.infosys.service.api.model.CarShowApiModel;
import com.github.achuzhmarov.infosys.service.api.parser.CarApiResponseParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CarApiService extends BaseApiService {
    private final String ENDPOINT = "http://eacodingtest.digital.energyaustralia.com.au/api/v1/cars";

    private final RestTemplate restTemplate;

    public CarApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CarShowApiModel> getCarShows() {
        return callWithRetries(this::getCarShowsRest);
    }

    private List<CarShowApiModel> getCarShowsRest() {
        ResponseEntity<String> response = restTemplate.getForEntity(ENDPOINT, String.class);
        return new CarApiResponseParser().parseResponse(response.getBody());
    }
}
