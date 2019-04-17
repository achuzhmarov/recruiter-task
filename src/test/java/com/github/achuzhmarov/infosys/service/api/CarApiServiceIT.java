package com.github.achuzhmarov.infosys.service.api;

import com.github.achuzhmarov.infosys.service.api.model.CarShowApiModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CarApiServiceIT {
    @Autowired
    CarApiService carApiService;

    @Test
    //Checks only no exceptions scenario because of the inconsistent service results
    //Test can be used interactively to see real service results
    public void getCarShows_noErrors() {
        List<CarShowApiModel> carShows = carApiService.getCarShows();
        System.out.println(carShows);
    }
}
