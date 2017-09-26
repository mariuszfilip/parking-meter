package com.pwsip.pl.parkingmeter.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mariusz on 18.09.17.
 */
@Entity
@Table(name = "parking_usage")
public class ParkingUsage {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date_start",nullable = false)
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "fee")
    private BigDecimal fee;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_driver")
    private Driver driver;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
