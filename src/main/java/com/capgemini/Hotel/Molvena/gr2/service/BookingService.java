package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import com.capgemini.Hotel.Molvena.gr2.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @PostConstruct
    public void init(){
        Booking booking1 = new Booking();
        booking1.setGuestID("1");
        booking1.setRoomID("1");
        booking1.setDesiredPeriodFrom("01-03-2018");
        booking1.setDesiredPeriodTill("01-04-2018");

        this.bookingRepository.save(booking1);

    }

    public Booking findById(long id){

    return this.bookingRepository.findOne(id);

    }

    public Iterable<Booking> allBookings(){
    return this.bookingRepository.findAll();

    }

    public Booking newBooking(Booking booking){
        this.bookingRepository.save(booking);
        return booking;
    }


}
