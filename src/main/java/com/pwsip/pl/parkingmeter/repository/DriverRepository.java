package com.pwsip.pl.parkingmeter.repository;

import com.pwsip.pl.parkingmeter.entity.Driver;
import com.pwsip.pl.parkingmeter.entity.ParkingUsage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mariusz on 18.09.17.
 */
@Repository
public interface DriverRepository extends CrudRepository<Driver,Long>{

    public Driver findByIdCard(String idCard);
}
