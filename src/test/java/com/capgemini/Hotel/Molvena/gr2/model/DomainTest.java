package com.capgemini.Hotel.Molvena.gr2.model;

import com.capgemini.Hotel.Molvena.gr2.data.Dates;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;
import org.springframework.boot.test.context.SpringBootTest;

public class DomainTest {

    @Test
    public void testGettersAndSettersForStandardTypes() {
        BeanTester tester = new BeanTester();


        tester.testBean(Dates.class);
        tester.testBean(Room.class);
        tester.testBean(Price.class);
    }

    @Test
    public void testGettersAndSettersForDifficulterTypes() {
        BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
                .ignoreProperty("desiredPeriodFrom")
                .ignoreProperty("desiredPeriodTill")
                .ignoreProperty("checkIn")
                .ignoreProperty("checkOut")
                .build();

        tester.testBean(Booking.class, configuration);
        tester.testBean(SearchRoom.class, configuration);
    }
}
