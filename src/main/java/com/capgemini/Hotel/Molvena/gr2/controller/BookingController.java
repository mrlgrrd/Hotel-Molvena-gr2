package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import com.capgemini.Hotel.Molvena.gr2.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookingcontroller/")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "newbooking", method = RequestMethod.POST)
    public void newBooking(@RequestBody Booking bookingToSave) {

        bookingService.newBooking(bookingToSave);

    }

    @RequestMapping(value = "showbookings", method = RequestMethod.GET)
    public Iterable<Booking> showBookings() {

        return bookingService.allBookings();
    }

//    @RequestMapping(value = "deletebooking", method = RequestMethod.DELETE)
//    public void deletebooking(Long id){
//
//        bookingService.deleteBooking(id);
//    }


}
