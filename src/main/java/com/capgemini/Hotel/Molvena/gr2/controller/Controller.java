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


}
