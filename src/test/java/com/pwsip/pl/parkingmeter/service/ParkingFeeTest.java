package com.pwsip.pl.parkingmeter.service;

import com.pwsip.pl.parkingmeter.entity.Driver;
import com.pwsip.pl.parkingmeter.entity.DriverType;
import com.pwsip.pl.parkingmeter.entity.ParkingUsage;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by mariusz on 26.09.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {TestConfig.class}
)
public class ParkingFeeTest {

    @Autowired
    private ParkingFee parkingFee;

    @Test
    public void testCalculateFeeForFirstHourForRegularDriver() {

        DateTime startDate = new DateTime();
        DateTime dateEnd = startDate.plus(Period.hours(1));

        Driver driver = new Driver();
        driver.setType(DriverType.Regular);

        ParkingUsage parkingUsage = new ParkingUsage();
        parkingUsage.setDateStart(startDate.toDate());
        parkingUsage.setDateEnd(dateEnd.toDate());
        parkingUsage.setDriver(driver);

        BigDecimal feeForParking = parkingFee.calculate(parkingUsage);


        assertEquals(new BigDecimal(1), feeForParking);


    }

    @Test
    public void testCalculateFeeForSecondHourForRegularDriver() {

        DateTime startDate = new DateTime();
        DateTime dateEnd = startDate.plus(Period.hours(2));

        Driver driver = new Driver();
        driver.setType(DriverType.Regular);

        ParkingUsage parkingUsage = new ParkingUsage();
        parkingUsage.setDateStart(startDate.toDate());
        parkingUsage.setDateEnd(dateEnd.toDate());
        parkingUsage.setDriver(driver);

        BigDecimal feeForParking = parkingFee.calculate(parkingUsage);

        assertEquals(new BigDecimal(2), feeForParking);
    }


    @Test
    public void testCalculateFeeForThirdHourForRegularDriver() {

        DateTime startDate = new DateTime();
        DateTime dateEnd = startDate.plus(Period.hours(3));

        Driver driver = new Driver();
        driver.setType(DriverType.Regular);
        ParkingUsage parkingUsage = new ParkingUsage();
        parkingUsage.setDateStart(startDate.toDate());
        parkingUsage.setDateEnd(dateEnd.toDate());
        parkingUsage.setDriver(driver);

        BigDecimal feeForParking = parkingFee.calculate(parkingUsage);

        assertEquals(new BigDecimal(4), feeForParking);


    }


    @Test
    public void testCalculateFeeForFirstHourForVipDriver() {

        DateTime startDate = new DateTime();
        DateTime dateEnd = startDate.plus(Period.hours(1));

        Driver driver = new Driver();
        driver.setType(DriverType.Vip);

        ParkingUsage parkingUsage = new ParkingUsage();
        parkingUsage.setDateStart(startDate.toDate());
        parkingUsage.setDateEnd(dateEnd.toDate());
        parkingUsage.setDriver(driver);

        BigDecimal feeForParking = parkingFee.calculate(parkingUsage);


        assertEquals(new BigDecimal(0), feeForParking);
    }

    @Test
    public void testCalculateFeeForSecondHourForVipDriver() {

        DateTime startDate = new DateTime();
        DateTime dateEnd = startDate.plus(Period.hours(2));

        Driver driver = new Driver();
        driver.setType(DriverType.Vip);

        ParkingUsage parkingUsage = new ParkingUsage();
        parkingUsage.setDateStart(startDate.toDate());
        parkingUsage.setDateEnd(dateEnd.toDate());
        parkingUsage.setDriver(driver);

        BigDecimal feeForParking = parkingFee.calculate(parkingUsage);

        assertEquals(new BigDecimal(2), feeForParking);
    }


    @Test
    public void testCalculateFeeForThirdHourForVipDriver() {

        DateTime startDate = new DateTime();
        DateTime dateEnd = startDate.plus(Period.hours(3));

        Driver driver = new Driver();
        driver.setType(DriverType.Vip);
        ParkingUsage parkingUsage = new ParkingUsage();
        parkingUsage.setDateStart(startDate.toDate());
        parkingUsage.setDateEnd(dateEnd.toDate());
        parkingUsage.setDriver(driver);

        BigDecimal feeForParking = parkingFee.calculate(parkingUsage);

        assertEquals(0,feeForParking.compareTo(new BigDecimal(3)));


    }



}
