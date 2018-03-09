package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.data.BookingModel;
import com.capgemini.Hotel.Molvena.gr2.data.Dates;
import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import com.capgemini.Hotel.Molvena.gr2.model.Room;
import com.capgemini.Hotel.Molvena.gr2.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookingcontroller/")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "newbooking", method = RequestMethod.POST)
    public void newBooking(@RequestBody BookingModel bookingModel) {


        bookingService.addBooking(bookingModel);

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

    @RequestMapping(value = "searchbooking/{searchvalue}", method = RequestMethod.GET)
    public Iterable<Booking> searchbooking(@PathVariable String searchvalue){
        return bookingService.searchBooking(searchvalue);
    }

    @RequestMapping(value = "deletebooking/{id}", method = RequestMethod.DELETE)
    public void deletebooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
    }

    @RequestMapping(value = "findbooking/{id}", method = RequestMethod.GET)
    public Booking findBooking(@PathVariable Long id){
        return bookingService.findById(id);
    }

    @RequestMapping(value = "checkavailability/{dates}", method = RequestMethod.GET)
    public void checkAvailability(@PathVariable Dates dates){
        bookingService.checkWhetherAvailable(dates);
    }

//    @RequestMapping(value = "deletebooking", method = RequestMethod.DELETE)
//    public void deletebooking(Long id){
//
//        bookingService.deleteBooking(id);
//    }


}
