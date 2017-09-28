package com.pwsip.pl.parkingmeter.service;

import com.pwsip.pl.parkingmeter.repository.DriverRepository;
import com.pwsip.pl.parkingmeter.repository.ParkingUsageRepository;
import com.pwsip.pl.parkingmeter.repository.VehicleRepository;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by mariusz on 25.09.17.
 */

@Configuration
@ComponentScan({"com.pwsip.pl.parkingmeter.service"})
public class TestConfig {

    @Bean
    @Primary
    public ParkingUsageRepository parkingRepo() {
        return Mockito.mock(ParkingUsageRepository.class);
    }

    @Bean
    @Primary
    public DriverRepository driverRepo() {
        return Mockito.mock(DriverRepository.class);
    }

    @Bean
    @Primary
    public VehicleRepository vehicleRepo() {
        return Mockito.mock(VehicleRepository.class);
    }

    @Bean
    @Primary
    @Qualifier("ParkingFeeMock")
    public ParkingFee parkingFeeMock() {
        return Mockito.mock(ParkingFee.class);
    }

    @Bean
    @Qualifier("ParkingFee")
    public ParkingFee parkingFee() {
        return new ParkingFee();
    }

}
