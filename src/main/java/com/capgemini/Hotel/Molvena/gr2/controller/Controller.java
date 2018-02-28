package com.capgemini.Hotel.Molvena.gr2.controller;


import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.service.RoomService;
import com.capgemini.Hotel.Molvena.gr2.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/controller/")
public class Controller {

    @Autowired
    private RoomService roomService;

    public Controller() {
    }

    /**
     * @param guestToSave add Guest to guest list
     */

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
    public void deleteguest(){

    }

    /**
     * getters & setters
     *
     * @return properties
     */



}
