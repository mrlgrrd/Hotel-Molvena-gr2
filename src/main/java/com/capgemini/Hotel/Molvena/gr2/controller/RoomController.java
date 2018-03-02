package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.model.Room;
import com.capgemini.Hotel.Molvena.gr2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roomcontroller/")
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * this method gets the list of rooms from the repository
     */
    @RequestMapping(value = "showrooms", method = RequestMethod.GET)
    public Iterable<Room> showRooms() {
        return roomService.allRooms();

    }

    @RequestMapping(value = "deleteroom", method = RequestMethod.DELETE)
    public void deleteRoom(Long id) {
        roomService.deleteRoom(id);
    }

    @RequestMapping(value = "addroom", method = RequestMethod.POST)
    public void addRoom(@RequestBody Room newRoom){
        roomService.addRoom(newRoom);
    }

    public void updateRoom(@RequestBody Room updateRoom){

    }

    @RequestMapping(value = "findroombyid", method = RequestMethod.GET)
    public Room findRoom(Long id){
        return this.roomService.findRoomById(id);
    }

}
