package com.github.achuzhmarov.infosys.service;

import com.github.achuzhmarov.infosys.model.CarMake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CarServiceIT {
    @Autowired
    CarService carService;

    @Test
    //Checks only no exceptions scenario because of the inconsistent service results
    //Test can be used interactively to see real service results
    public void getCarMakes_noErrors() {
        List<CarMake> carMakes = carService.getCarMakes();
        System.out.println(carMakes);
    }
}
