package com.pwsip.pl.parkingmeter.service;

import com.pwsip.pl.parkingmeter.entity.ParkingUsage;
import com.pwsip.pl.parkingmeter.exception.TicketNotFoundException;
import com.pwsip.pl.parkingmeter.repository.ParkingUsageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by mariusz on 25.09.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader=AnnotationConfigContextLoader.class,
        classes = { TestConfig.class }
)
public class ParkingStopTest {
    @Autowired
    private ParkingUsageRepository parkingUsageRepository;

    @Autowired
    private ParkingStop parkingStop;


    @Before
    public void setUp() {
        Mockito.reset(parkingUsageRepository);
    }

    @Test(expected = TicketNotFoundException.class)
    public void testStopParkingWithNotFoundTicket() throws TicketNotFoundException {
        Long ticketId = 13L;
        given(parkingUsageRepository.findById(ticketId)).willReturn(null);
        parkingStop.run(ticketId);
        verify(parkingUsageRepository,times(1)).findById(ticketId);
    }


    @Test
    public void testStopParking() throws TicketNotFoundException {
        ParkingUsage parkingUsage = new ParkingUsage();

        Long ticketId = 13L;
        given(parkingUsageRepository.findById(ticketId)).willReturn(java.util.Optional.ofNullable(parkingUsage));

        parkingStop.run(ticketId);

        verify(parkingUsageRepository,times(1)).findById(ticketId);
        verify(parkingUsageRepository,times(1)).save(any(ParkingUsage.class));
    }

}
