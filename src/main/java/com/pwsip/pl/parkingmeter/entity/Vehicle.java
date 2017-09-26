package com.pwsip.pl.parkingmeter.entity;

import javax.persistence.*;

/**
 * Created by mariusz on 18.09.17.
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "registration_number")
    private String registrationNumber;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
