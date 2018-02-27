package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.model.Room;
import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.repositories.GuestRepository;
import com.capgemini.Hotel.Molvena.gr2.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api/controller/")
public class Controller {

    @Autowired
    private RoomRepository roomRepository;

    public Controller() {
    }

    /**
     * add a room to the arraylist of rooms
     */
//    @RequestMapping(value = "addroom", method = RequestMethod.POST)
//    public void addRoom(@RequestBody Room roomToSave) {
//        roomRepository.saveRoom(roomToSave);
//    }

    /**
     * this method gets the list of rooms from the repository
     */
//    @RequestMapping(value = "showrooms", method = RequestMethod.GET)
//    public List<Room> showRooms() {
//        return roomRepository.getRooms();
//
//    }

    /**
     * this method lets you change the properties of the room
     *
     * @param number    room number
     * @param RoomType room type
     */
//    @RequestMapping(value = "updateroom", method = RequestMethod.POST)
//    public void updateRoom(@RequestBody Room roomToUpdate) {
//        roomRepository.updateRoom(roomToUpdate);
//    }

    /**
     * delete a room from the array list of rooms
     *
     * @param number roomnumber
     */
//    @RequestMapping(value = "deleteroom", method = RequestMethod.DELETE)
//    public void deleteRoom(@RequestParam int number) {
//        roomRepository.deleteRoom(number);
//    }

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
