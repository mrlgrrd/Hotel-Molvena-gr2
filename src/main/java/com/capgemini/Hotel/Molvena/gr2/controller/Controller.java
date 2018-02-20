package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {

    private ArrayList<Room> rooms = new ArrayList<Room>();
    private Room room;

    @GetMapping("/api/initializerooms")
    public ArrayList<Room> initializeRooms() {

        Room room1 = new Room(ERoomType.STANDARD, 1);
        this.rooms.add(room1);
        Room room2 = new Room(ERoomType.STANDARD, 2);
        this.rooms.add(room2);
        return rooms;

    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
