package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.Room;
import com.capgemini.Hotel.Molvena.gr2.person.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {

    private ArrayList<Room> rooms = new ArrayList<Room>();
    private Room room;

    private ArrayList<Person> guests = new ArrayList<Person>();
    private Person guest;

    /**
     * initialize the rooms
     *
     * @return room
     */
    @GetMapping("/api/initializerooms")
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
     * @param ERoomType enum roomtype
     * @param number room number
     * @return list of rooms
     */
    @GetMapping("/api/addroom")
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
    @GetMapping("/api/changeroom")
    public Room changeRoom(int number, Enum<ERoomType> ERoomType) {
        if (room.getNumber() == number) {
            this.room.setRoomType(ERoomType);
        }
        return room;
    }

    /**
     * delete a room from the array list of rooms
     *
     * @param number roomnumber
     */
    @GetMapping("/api/deleteroom")
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

    public ArrayList<Person> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Person> guests) {
        this.guests = guests;
    }

    public Person getGuest() {
        return guest;
    }

    public void setGuest(Person guest) {
        this.guest = guest;
    }
}
