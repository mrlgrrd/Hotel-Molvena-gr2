package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guestcontroller/")
public class GuestController {


    @Autowired
    private GuestService guestService;



    @RequestMapping(value = "addtoguest", method = RequestMethod.POST)
    public void newguest(@RequestBody Guest guestToSave) {

        guestService.addToGuest(guestToSave);

    }

    @RequestMapping(value = "searchguest/{searchvalue}", method = RequestMethod.GET)
    public Iterable<Guest> searchguest(@PathVariable String searchvalue){
        return guestService.searchGuests(searchvalue);
    }


    @RequestMapping(value = "allguests", method = RequestMethod.GET)
    public Iterable<Guest> indexGuest() {

        return guestService.getGuests();
    }

    @RequestMapping(value = "deleteguest", method = RequestMethod.DELETE)
    public void deleteguest(Long id){
        guestService.deleteGuest(id);
    }

    @RequestMapping(value = "findguest", method = RequestMethod.GET)
    public Guest findGuest(Long id){
        return guestService.findById(id);
    }

}
