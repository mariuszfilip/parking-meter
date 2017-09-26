package com.pwsip.pl.parkingmeter.controllers;

import com.pwsip.pl.parkingmeter.service.ParkingCheckVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mariusz on 25.09.17.
 */
@RestController
@RequestMapping(value = "parkingoperator")
public class ParkingOperatorController {

    @Autowired
    private ParkingCheckVehicle parkingCheckVehicle;

    @RequestMapping(value = "checkvehicle",method = RequestMethod.GET)
    public ResponseEntity checkvehicle(@RequestParam(value = "registrationNumber",required = true) String registrationNumber){
        if(!this.parkingCheckVehicle.check(registrationNumber)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
