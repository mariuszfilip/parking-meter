package com.pwsip.pl.parkingmeter.entity;

import javax.persistence.*;

/**
 * Created by mariusz on 18.09.17.
 */
@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "type")
    private DriverType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public DriverType getType() {
        return type;
    }

    public void setType(DriverType type) {
        this.type = type;
    }
}
