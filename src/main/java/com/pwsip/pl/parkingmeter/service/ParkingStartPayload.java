package com.pwsip.pl.parkingmeter.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mariusz on 18.09.17.
 */
public class ParkingStartPayload {

    @JsonProperty(value = "driverIdCard", required = true)
    @NotEmpty
    private String driverIdCard;

    @JsonProperty(value = "vehicleRegistrationNumber", required = true)
    @NotEmpty
    private String vehicleRegistrationNumber;

    public void setDriverIdCard(String driverIdCard) {
        this.driverIdCard = driverIdCard;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public String getDriverIdCard() {
        return driverIdCard;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }
}
