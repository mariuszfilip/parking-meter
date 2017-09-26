package com.pwsip.pl.parkingmeter.controllers;

import com.pwsip.pl.parkingmeter.exception.TicketNotFoundException;
import com.pwsip.pl.parkingmeter.service.ParkingStart;
import com.pwsip.pl.parkingmeter.service.ParkingStartPayload;
import com.pwsip.pl.parkingmeter.service.ParkingStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by mariusz on 18.09.17.
 */

@RestController
@RequestMapping(value = "driver")
public class DriverController {

    private ParkingStart parkingStart;

    private ParkingStop parkingStop;

    @Autowired
    public void setParkingStop(ParkingStop parkingStop) {
        this.parkingStop = parkingStop;
    }

    @Autowired
    public void setParkingStart(ParkingStart parkingStart) {
        this.parkingStart = parkingStart;
    }

    @RequestMapping(value = "start",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity start(@Valid @RequestBody ParkingStartPayload parkingStartPayload ){
        try{
            return new ResponseEntity(this.parkingStart.run(parkingStartPayload),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "stop")
    public ResponseEntity stop(@RequestParam(value = "ticketId",required = true) Long ticketId){
        try{
            this.parkingStop.run(ticketId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (TicketNotFoundException t){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
