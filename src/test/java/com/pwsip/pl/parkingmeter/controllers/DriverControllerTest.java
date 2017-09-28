package com.pwsip.pl.parkingmeter.controllers;

import com.pwsip.pl.parkingmeter.service.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by mariusz on 28.09.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {TestConfig.class}
)
public class DriverControllerTest {

    @Test
    public void parkingStartForCar() {
    }






}
