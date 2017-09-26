package com.pwsip.pl.parkingmeter.service;

import com.pwsip.pl.parkingmeter.entity.ParkingUsage;
import com.pwsip.pl.parkingmeter.repository.ParkingUsageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by mariusz on 25.09.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader=AnnotationConfigContextLoader.class,
        classes = { TestConfig.class }
)
public class ParkingCheckVehicleTest {

    @Autowired
    private ParkingUsageRepository parkingUsageRepository;

    @Autowired
    private ParkingCheckVehicle parkingCheckVehicle;


    @Before
    public void setUp() {
        Mockito.reset(parkingUsageRepository);
    }

    @Test
    public void testNotStartedParkingForVehicle(){
        String registrationNumber = "BL1231";
        given(parkingUsageRepository.findStartedParkingForVehicle(registrationNumber)).willReturn(null);

        Boolean result = parkingCheckVehicle.check(registrationNumber);

        verify(parkingUsageRepository,times(1)).findStartedParkingForVehicle(registrationNumber);
        assertEquals(false,result);

    }

    @Test
    public void testStartedParkingForVehicle(){
        ParkingUsage parkingUsage = new ParkingUsage();
        String registrationNumber = "BL1231";
        given(parkingUsageRepository.findStartedParkingForVehicle(registrationNumber)).willReturn(parkingUsage);

        Boolean result = parkingCheckVehicle.check(registrationNumber);

        verify(parkingUsageRepository,times(1)).findStartedParkingForVehicle(registrationNumber);
        assertEquals(true,result);
    }

}
