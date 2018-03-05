package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import com.capgemini.Hotel.Molvena.gr2.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "findguestbookings/{guest_id}", method = RequestMethod.GET)
    public Iterable<Booking> findGuestBookings(@PathVariable Long guest_id){
        System.out.println(guest_id);
        return bookingService.guestBooking(guest_id);
    }

//    @RequestMapping(value = "deletebooking", method = RequestMethod.DELETE)
//    public void deletebooking(Long id){
//
//        bookingService.deleteBooking(id);
//    }


}
