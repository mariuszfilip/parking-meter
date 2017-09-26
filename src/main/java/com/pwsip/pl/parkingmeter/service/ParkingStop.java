package com.pwsip.pl.parkingmeter.service;

import com.pwsip.pl.parkingmeter.entity.ParkingUsage;
import com.pwsip.pl.parkingmeter.exception.TicketNotFoundException;
import com.pwsip.pl.parkingmeter.repository.ParkingUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

/**
 * Created by mariusz on 18.09.17.
 */
@Service
public class ParkingStop {

    private ParkingUsageRepository parkingUsageRepository;

    @Autowired
    public ParkingStop(ParkingUsageRepository parkingUsageRepository) {
        this.parkingUsageRepository = parkingUsageRepository;
    }

    public void run(Long ticketId) throws TicketNotFoundException {
        Optional<ParkingUsage> parkingUsage = this.parkingUsageRepository.findById(ticketId);
        if(parkingUsage == null){
            throw new TicketNotFoundException();
        }
        parkingUsage.get().setDateEnd(new Date());
        this.parkingUsageRepository.save(parkingUsage.get());

    }



}
