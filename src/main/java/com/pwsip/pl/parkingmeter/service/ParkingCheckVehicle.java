package com.pwsip.pl.parkingmeter.service;

import com.pwsip.pl.parkingmeter.entity.ParkingUsage;
import com.pwsip.pl.parkingmeter.repository.ParkingUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mariusz on 25.09.17.
 */
@Service
public class ParkingCheckVehicle {

    private ParkingUsageRepository parkingUsageRepository;

    @Autowired
    public ParkingCheckVehicle(ParkingUsageRepository parkingUsageRepository) {
        this.parkingUsageRepository = parkingUsageRepository;
    }


    public Boolean check(String registrationNumber) {
        ParkingUsage parkingUsage = this.parkingUsageRepository.findStartedParkingForVehicle(registrationNumber);
        return parkingUsage != null;
    }
}
