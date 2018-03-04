package com.capgemini.Hotel.Molvena.gr2.service;
import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import com.capgemini.Hotel.Molvena.gr2.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


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
