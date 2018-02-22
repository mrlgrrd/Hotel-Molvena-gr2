package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.Room;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/controller/")
public class Controller {

    private ArrayList<Room> rooms = new ArrayList<Room>();
    private Room room;
    private ArrayList<Guest> guests = new ArrayList<Guest>();

    private Guest guest;

    /**
     * initialize the rooms
     *
     * @return room
     */
    @RequestMapping("initializerooms")
    public ArrayList<Room> initializeRooms() {

        Room room1 = new Room(ERoomType.STANDARD, 1);
        Room room2 = new Room(ERoomType.STANDARD, 2);
        Room room3 = new Room(ERoomType.DELUXE, 3);
        Room room4 = new Room(ERoomType.DELUXE, 4);
        Room room5 = new Room(ERoomType.HONEYMOON, 5);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);

        return rooms;
    }

    /**
     * add a rom to the arraylist of rooms
     *
     * @param ERoomType enum roomtype
     * @param number    room number
     * @return list of rooms
     */
    @RequestMapping("addroom")
    public ArrayList<Room> addRoom(Enum<ERoomType> ERoomType, int number) {
        rooms.add(new Room(ERoomType, number));
        return rooms;
    }

    /**
     * this method lets you change the properties of the room
     *
     * @param number    room number
     * @param ERoomType room type
     * @return room
     */
    @RequestMapping("changeroom")
    public Room changeRoom(int number, Enum<ERoomType> ERoomType) {
        if (room.getNumber() == number) {
            this.room.setRoomType(ERoomType);
        }
        return room;
    }

    @RequestMapping("showrooms")
    public ArrayList<Room> showRooms(){
        return rooms;
    }



    @GetMapping("/api/addGuest")
    public void addGuest(@RequestParam Guest guestToSave){

        //return "Hello there " + name;
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


    /**
     * delete a room from the array list of rooms
     *
     * @param number roomnumber
     */
    @RequestMapping("deleteroom")
    public void deleteRoom(int number) {
        if (room.getNumber() == number) {
            rooms.remove(room);
        }
    }

    /**
     * getters & setters
     *
     * @return properties
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
