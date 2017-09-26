package com.pwsip.pl.parkingmeter.repository;

import com.pwsip.pl.parkingmeter.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mariusz on 18.09.17.
 */
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Long> {
    public Vehicle findByRegistrationNumber(String registrationNumber);
}
