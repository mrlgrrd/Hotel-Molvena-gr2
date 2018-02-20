package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.Room;
import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {

    private ArrayList<Room> rooms = new ArrayList<Room>();
    private Room room;
    private ArrayList<Guest> guests = new ArrayList<Guest>();

    @GetMapping("/api/initializerooms")
    public ArrayList<Room> initializeRooms() {

        Room room1 = new Room(ERoomType.STANDARD, 1);
        this.rooms.add(room1);
        Room room2 = new Room(ERoomType.STANDARD, 2);
        this.rooms.add(room2);
        return rooms;

    }

    public ArrayList<Guest> addGuest() {

        return guests;
    }


    //Geknipt en geplakt uit Room
//    public ArrayList<Room> getRooms() {
//        return rooms;
//    }
//
//    //Make a list of rooms
//    ArrayList<Room> roomList = new ArrayList<Room>();
//
//    /**
//     * Methods that belong to room
//     */
//
//    /**
//     * this method checks which rooms are available in a given period
//     */
//    public void checkIfAvailable() {
//
//    }
//
//    /**
//     * this method lets you modify the properties of the room
//     *
//     * @param number    the room number
//     * @param Eroomtype the room type
//     */
//    public void changeRoom(int number, Enum<ERoomType> Eroomtype) {
//        //this.roomType = Eroomtype;
//        //this.number = number;
//
//    }
//
//    /**
//     * this method removes a room from the system
//     */
//    public void removeRoom() {
//
//    }
}
