package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.repositories.BookingRepository;
import com.capgemini.Hotel.Molvena.gr2.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class GenericService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private GuestRepository guestRepository;

    @PostConstruct
    public void init(){

        Booking b1 = new Booking();
        b1.setDesiredPeriodFrom("05-03-2018");
        b1.setDesiredPeriodTill("06-03-2018");
        this.bookingRepository.save(b1);

        Guest guest1 = new Guest();
        guest1.setFirstname("Jeremy");
        guest1.setLastname("Jones");
        this.guestRepository.save(guest1);

        b1.setGuest(guest1);
        this.bookingRepository.save(b1);
        this.guestRepository.save(guest1);




    }

}
