package com.github.achuzhmarov.infosys.service.api.parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.achuzhmarov.infosys.exception.ApiCallException;
import com.github.achuzhmarov.infosys.service.api.model.CarShowApiModel;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Response parser for api/v1/cars
 * Contains specific processing logic
 */
public class CarApiResponseParser {
    public List<CarShowApiModel> parseResponse(String response) {
        //TODO: What is the expected outcome for empty or null responseBody?
        //TODO: What is the expected outcome for '""' responseBody?
        if (response == null || response.isEmpty() || response.equals("\"\"")) {
            return Collections.emptyList();
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response, new TypeReference<List<CarShowApiModel>>(){});
        } catch (JsonParseException | JsonMappingException e) {
            throw new ApiCallException("Error parsing carShowApiModel from CarApi", response, e);
        } catch (IOException e) {
            //should not happen
            throw new ApiCallException("Unexpected IOException during carShowApiModel parsing from CarApi", response, e);
        }
    }
}
