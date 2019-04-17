package com.github.achuzhmarov.infosys.controller;

import com.github.achuzhmarov.infosys.model.CarMake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CarMakeControllerIT {
    @Autowired
    CarMakeController carMakeController;

    @Test
    //Checks only no exceptions scenario because of the inconsistent service results
    //Test can be used interactively to see real service results
    public void printCarMakes_noErrors() {
        carMakeController.printCarMakes();
    }

    @Test
    //Checks only no exceptions scenario because of the inconsistent service results
    //Test can be used interactively to see real service results
    public void getCarMakesJson_noErrors() {
        List<CarMake> result = carMakeController.getCarMakesJson();
        System.out.println(result);
    }
}
