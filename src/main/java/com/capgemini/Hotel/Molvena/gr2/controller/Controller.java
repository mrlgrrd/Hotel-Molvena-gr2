package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.model.Room;
import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.repositories.GuestRepository;
import com.capgemini.Hotel.Molvena.gr2.repositories.RoomRepository;
import com.capgemini.Hotel.Molvena.gr2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    private GuestRepository guestRepository;



    @RequestMapping(value = "newguest", method = RequestMethod.POST)
    public void newguest(@RequestBody Guest guestToSave) {

        guestRepository.newGuest(guestToSave);


    }


    @RequestMapping(value = "allguests", method = RequestMethod.GET)
    public List<Guest> indexGuest() {

        return guestRepository.getGuests();
    }

    /**
     * getters & setters
     *
     * @return properties
     */



}
