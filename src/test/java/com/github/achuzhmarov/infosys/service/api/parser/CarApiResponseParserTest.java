package com.github.achuzhmarov.infosys.service.api.parser;

import com.github.achuzhmarov.infosys.service.api.model.CarShowApiModel;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static com.github.achuzhmarov.infosys.builder.CommonBuilder.listOf;
import static com.github.achuzhmarov.infosys.builder.api.CarShowApiBuilder.carShow;
import static org.junit.Assert.assertEquals;

public class CarApiResponseParserTest {
    private CarApiResponseParser parser = new CarApiResponseParser();

    @Test
    public void parseResponse_emptyString_emptyResult() {
        assertParseResult(Collections.emptyList(), "");
    }

    @Test
    public void parseResponse_nullString_emptyResult() {
        assertParseResult(Collections.emptyList(), null);
    }

    @Test
    public void parseResponse_oneShowOneCar_modelParsed() {
        String response = "[{\"name\":\"New York Car Show\",\"cars\":[{\"make\":\"Hondaka\",\"model\":\"Elisa\"}]}]";
        List<CarShowApiModel> expectedResult = listOf(
                carShow("New York Car Show").addCar("Hondaka", "Elisa").build()
        );

        assertParseResult(expectedResult, response);
    }

    @Test
    public void parseResponse_oneShowTwoCars_modelParsed() {
        String response =
            "[" +
                "{\"name\":\"New York Car Show\"," + "\"cars\":[" +
                    "{\"make\":\"Hondaka\",\"model\":\"Elisa\"}," +
                    "{\"make\":\"George Motors\",\"model\":\"George 15\"}" +
                "]}" +
            "]";

        List<CarShowApiModel> expectedResult = listOf(
                carShow("New York Car Show")
                        .addCar("Hondaka", "Elisa")
                        .addCar("George Motors", "George 15")
                        .build()
        );

        assertParseResult(expectedResult, response);
    }

    @Test
    public void parseResponse_twoShows_modelParsed() {
        String response =
                "[" +
                    "{\"name\":\"New York Car Show\",\"cars\":[{\"make\":\"Hondaka\",\"model\":\"Elisa\"}]}," +
                    "{\"name\":\"Melbourne Motor Show\",\"cars\":[{\"make\":\"Julio Mechannica\",\"model\":\"Mark 4S\"}]}" +
                "]";

        List<CarShowApiModel> expectedResult = listOf(
                carShow("New York Car Show").addCar("Hondaka", "Elisa").build(),
                carShow("Melbourne Motor Show").addCar("Julio Mechannica", "Mark 4S").build()
        );

        assertParseResult(expectedResult, response);
    }

    private void assertParseResult(List<CarShowApiModel> expectedResult, String response) {
        List<CarShowApiModel> result = parser.parseResponse(response);
        assertEquals(expectedResult, result);
    }
}
