package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.Room;
import com.capgemini.Hotel.Molvena.gr2.person.Guest;



import com.capgemini.Hotel.Molvena.gr2.repositories.GuestRepository;

import com.capgemini.Hotel.Molvena.gr2.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/controller/")
public class Controller {

    private Room room;
    private ArrayList<Guest> guests = new ArrayList<Guest>();
    private Guest guest;

    @Autowired
    private RoomRepository roomRepository;

    /**
     * add a rom to the arraylist of rooms
     */
    @RequestMapping(value = "addroom", method = RequestMethod.POST)
    public void addRoom(@RequestBody Room roomToSave) {
        roomRepository.saveRoom(roomToSave);
    }

    /**
     * this method lets you change the properties of the room
     *
     * @param number    room number
     * @param ERoomType room type
     */
    @RequestMapping(value = "updateroom", method = RequestMethod.POST)
    public void updateRoom(@RequestBody int number, @RequestBody Enum<ERoomType> ERoomType) {
        roomRepository.updateRoom(number, ERoomType);
    }

    /**
     *
     * @param guestToSave add Guest to guest list
     */

    @Autowired
    private GuestRepository guestRepository;

    @RequestMapping(value = "addguest",method = RequestMethod.POST)
    public void addGuest(@RequestParam Guest guestToSave){
        guestRepository.saveGuest(guestToSave);

    }

    @RequestMapping(value = "allguests", method = RequestMethod.GET)
    public List<Guest> indexGuest() {
        return guestRepository.getGuests();
    }

    /**
     * this method gets the list of rooms from the repository
     */
    @RequestMapping(value = "showrooms", method = RequestMethod.GET)
    public void showRooms() {
        roomRepository.getRooms();

    }

    /**
     * delete a room from the array list of rooms
     *
     * @param number roomnumber
     */
    @RequestMapping("deleteroom")
    public void deleteRoom(int number) {
        roomRepository.deleteRoom(number);
    }
    

    /**
     * getters & setters
     *
     * @return properties
     */
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
