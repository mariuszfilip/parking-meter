package com.pwsip.pl.parkingmeter.service;

import com.pwsip.pl.parkingmeter.entity.ParkingUsage;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


/**
 * Created by mariusz on 26.09.17.
 */
@Service
public class ParkingFee {

    public BigDecimal calculate(ParkingUsage parkingUsage) {

        Period period = new Period(new DateTime(parkingUsage.getDateStart()), new DateTime(parkingUsage.getDateEnd()));

        double converter = 0;
        BigDecimal sum = new BigDecimal(0);
        switch (parkingUsage.getDriver().getType()) {
            case Regular:
                converter = 2;
                sum = new BigDecimal(1);
                break;
            case Vip:
                converter = 1.5;
                sum = new BigDecimal(0);
                break;
        }

        sum = calculateFeeForNextDays(period, converter, sum);
        return sum;
    }

    private BigDecimal calculateFeeForNextDays(Period period, double converter, BigDecimal sum) {
        int hours = period.getHours();
        int hoursCalculated = 1;
        while (hours > hoursCalculated) {
            hoursCalculated++;
            if (hoursCalculated == 2) {
                sum = new BigDecimal(2);
            } else {
                sum = sum.multiply(new BigDecimal(converter));
            }

        }
        return sum;
    }


}
