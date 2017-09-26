package com.pwsip.pl.parkingmeter.repository;

import com.pwsip.pl.parkingmeter.entity.ParkingUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by mariusz on 18.09.17.
 */
@Repository
public interface ParkingUsageRepository extends JpaRepository<ParkingUsage,Long> {

    @Query(value = "SELECT pu.* from parking_usage pu INNER JOIN vehicle v ON pu.id_vehicle = v.id WHERE v.registration_number = :registrationNumber",nativeQuery = true)
    public ParkingUsage findStartedParkingForVehicle(@Param("registrationNumber") String registrationNumber);
}
