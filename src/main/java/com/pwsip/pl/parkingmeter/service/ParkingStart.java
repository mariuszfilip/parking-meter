package com.pwsip.pl.parkingmeter.service;

import com.pwsip.pl.parkingmeter.entity.Driver;
import com.pwsip.pl.parkingmeter.entity.DriverType;
import com.pwsip.pl.parkingmeter.entity.ParkingUsage;
import com.pwsip.pl.parkingmeter.entity.Vehicle;
import com.pwsip.pl.parkingmeter.repository.DriverRepository;
import com.pwsip.pl.parkingmeter.repository.ParkingUsageRepository;
import com.pwsip.pl.parkingmeter.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by mariusz on 18.09.17.
 */
@Service
public class ParkingStart {

    private ParkingUsageRepository parkingUsageRepository;
    private DriverRepository driverRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public ParkingStart(ParkingUsageRepository parkingUsageRepository, DriverRepository driverRepository, VehicleRepository vehicleRepository) {
        this.parkingUsageRepository = parkingUsageRepository;
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Long run(ParkingStartPayload parkingStartPayload){
        Driver driver = driverRepository.findByIdCard(parkingStartPayload.getDriverIdCard());
        if(driver == null){
            driver = new Driver();
            driver.setIdCard(parkingStartPayload.getDriverIdCard());
            driver.setType(DriverType.Regular);
        }
        Vehicle vehicle = vehicleRepository.findByRegistrationNumber(parkingStartPayload.getVehicleRegistrationNumber());
        if(vehicle == null){
            vehicle = new Vehicle();
            vehicle.setRegistrationNumber(parkingStartPayload.getVehicleRegistrationNumber());
        }
        ParkingUsage parkingUsage = new ParkingUsage();
        parkingUsage.setDateStart(new Date());
        parkingUsage.setVehicle(vehicle);
        parkingUsage.setDriver(driver);

        parkingUsageRepository.save(parkingUsage);
        return parkingUsage.getId();
    }



}
