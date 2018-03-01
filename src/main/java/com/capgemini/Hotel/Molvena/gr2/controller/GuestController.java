package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guestcontroller/")
public class GuestController {


    @Autowired
    private GuestService guestService;



    @RequestMapping(value = "newguest", method = RequestMethod.POST)
    public void newguest(@RequestBody Guest guestToSave) {

        guestService.newGuest(guestToSave);

    }


    @RequestMapping(value = "allguests", method = RequestMethod.GET)
    public Iterable<Guest> indexGuest() {

        return guestService.getGuests();
    }

    @RequestMapping(value = "deleteguest", method = RequestMethod.DELETE)
    public void deleteguest(Long id){
        guestService.deleteGuest(id);
    }

}
