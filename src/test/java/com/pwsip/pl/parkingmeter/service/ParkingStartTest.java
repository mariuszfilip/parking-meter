package com.pwsip.pl.parkingmeter.service;

import com.pwsip.pl.parkingmeter.entity.Driver;
import com.pwsip.pl.parkingmeter.entity.ParkingUsage;
import com.pwsip.pl.parkingmeter.entity.Vehicle;
import com.pwsip.pl.parkingmeter.repository.DriverRepository;
import com.pwsip.pl.parkingmeter.repository.ParkingUsageRepository;
import com.pwsip.pl.parkingmeter.repository.VehicleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader=AnnotationConfigContextLoader.class,
        classes = { TestConfig.class }
        )

public class ParkingStartTest {
    @Autowired
    private ParkingUsageRepository parkingUsageRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingStart parkingStart;


    @Before
    public void setUp() {
        Mockito.reset(parkingUsageRepository);
        Mockito.reset(driverRepository);
        Mockito.reset(vehicleRepository);
    }

    @Test
    public void testStartParkingForNoExistDriverAndVehicle(){
        ParkingStartPayload parkingStartPayload = new ParkingStartPayload();
        parkingStartPayload.setDriverIdCard("APX1111");
        parkingStartPayload.setVehicleRegistrationNumber("BKL1232");

        given(driverRepository.findByIdCard(parkingStartPayload.getDriverIdCard())).willReturn(null);
        given(vehicleRepository.findByRegistrationNumber(parkingStartPayload.getVehicleRegistrationNumber())).willReturn(null);

        parkingStart.run(parkingStartPayload);


        verify(driverRepository,times(1)).findByIdCard(parkingStartPayload.getDriverIdCard());
        verify(vehicleRepository,times(1)).findByRegistrationNumber(parkingStartPayload.getVehicleRegistrationNumber());
        verify(parkingUsageRepository,times(1)).save(any(ParkingUsage.class));
    }



}
