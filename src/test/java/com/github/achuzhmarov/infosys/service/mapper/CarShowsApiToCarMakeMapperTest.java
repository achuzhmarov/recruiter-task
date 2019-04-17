package com.github.achuzhmarov.infosys.service.mapper;

import com.github.achuzhmarov.infosys.model.CarMake;
import com.github.achuzhmarov.infosys.service.api.model.CarShowApiModel;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static com.github.achuzhmarov.infosys.builder.CarMakeBuilder.carMake;
import static com.github.achuzhmarov.infosys.builder.CommonBuilder.listOf;
import static com.github.achuzhmarov.infosys.builder.api.CarShowApiBuilder.carShow;
import static org.junit.Assert.assertEquals;

public class CarShowsApiToCarMakeMapperTest {
    CarShowsApiToCarMakeMapper mapper = new CarShowsApiToCarMakeMapper();

    @Test
    public void map_emptyList_emptyResult() {
        assertMapResult(Collections.emptyList(), Collections.emptyList());
    }

    @Test
    public void map_emptyOrNullModel_emptyResult() {
        List<CarShowApiModel> carShows = listOf(
                carShow("New York Car Show").addCar("Hondaka", "").build(),
                carShow("New York Car Show").addCar("Hondaka", null).build()
        );

        assertMapResult(Collections.emptyList(), carShows);
    }

    @Test
    public void map_emptyOrNullShow_emptyResult() {
        List<CarShowApiModel> carShows = listOf(
                carShow("").addCar("Hondaka", "Elisa").build(),
                carShow(null).addCar("Hondaka", "Elisa").build()
        );

        assertMapResult(Collections.emptyList(), carShows);
    }

    @Test
    public void map_emptyOrNullMake_emptyResult() {
        List<CarShowApiModel> carShows = listOf(
                carShow("New York Car Show").addCar("", "Elisa").build(),
                carShow("New York Car Show").addCar(null, "Elisa").build()
        );

        assertMapResult(Collections.emptyList(), carShows);
    }

    @Test
    public void map_oneMakeOneCar_correctResult() {
        List<CarShowApiModel> carShows = listOf(
                carShow("New York Car Show").addCar("Hondaka", "Elisa").build()
        );

        List<CarMake> expectedResult = listOf(
                carMake("Hondaka").addCar("Elisa", "New York Car Show").build()
        );

        assertMapResult(expectedResult, carShows);
    }

    @Test
    public void map_twoCarsOneMake_correctResult() {
        List<CarShowApiModel> carShows = listOf(
                carShow("New York Car Show")
                        .addCar("Hondaka", "ElisaOne")
                        .addCar("Hondaka","ElisaTwo")
                        .build()
        );

        List<CarMake> expectedResult = listOf(
                carMake("Hondaka")
                        .addCar("ElisaOne", "New York Car Show")
                        .addCar("ElisaTwo", "New York Car Show")
                        .build()
        );

        assertMapResult(expectedResult, carShows);
    }

    @Test
    public void map_twoMakes_correctResult() {
        List<CarShowApiModel> carShows = listOf(
                carShow("New York Car Show")
                        .addCar("Hondaka", "Elisa")
                        .addCar("George Motors", "George 15")
                        .build()
        );

        List<CarMake> expectedResult = listOf(
                carMake("George Motors").addCar("George 15", "New York Car Show").build(),
                carMake("Hondaka").addCar("Elisa", "New York Car Show").build()
        );

        assertMapResult(expectedResult, carShows);
    }

    @Test
    public void map_twoShowsOneMake_correctResult() {
        List<CarShowApiModel> carShows = listOf(
                carShow("New York Car Show").addCar("Hondaka", "ElisaOne").build(),
                carShow("Other show").addCar("Hondaka", "ElisaTwo").build()
        );

        List<CarMake> expectedResult = listOf(
                carMake("Hondaka")
                        .addCar("ElisaOne", "New York Car Show")
                        .addCar("ElisaTwo", "Other show")
                        .build()
        );

        assertMapResult(expectedResult, carShows);
    }

    @Test
    public void map_twoShowsTwoMakes_correctResult() {
        List<CarShowApiModel> carShows = listOf(
                carShow("New York Car Show").addCar("Hondaka", "Elisa").build(),
                carShow("Other show").addCar("George Motors", "George 15").build()
        );

        List<CarMake> expectedResult = listOf(
                carMake("George Motors").addCar("George 15", "Other show").build(),
                carMake("Hondaka").addCar("Elisa", "New York Car Show").build()
        );

        assertMapResult(expectedResult, carShows);
    }

    @Test
    public void map_twoShowsOneCar_correctResult() {
        List<CarShowApiModel> carShows = listOf(
                carShow("Show1").addCar("Hondaka", "Elisa").build(),
                carShow("Show2").addCar("Hondaka", "Elisa").build()
        );

        List<CarMake> expectedResult = listOf(
                carMake("Hondaka").addCar("Elisa", "Show1", "Show2").build()
        );

        assertMapResult(expectedResult, carShows);
    }

    private void assertMapResult(List<CarMake> expectedResult, List<CarShowApiModel> carShows) {
        List<CarMake> result = mapper.map(carShows);
        assertEquals(expectedResult, result);
    }
}
