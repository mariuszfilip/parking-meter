package com.pwsip.pl.parkingmeter.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mariusz on 18.09.17.
 */
@Configuration
@EntityScan({
        "com.pwsip.pl.parkingmeter.entity"
})
public class JpaConfiguration {
}
