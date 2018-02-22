package com.capgemini.Hotel.Molvena.gr2.repositories;

import com.capgemini.Hotel.Molvena.gr2.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {

    // creation of list of rooms
    List<Room> rooms = new ArrayList<>();


    /**
     * constructor generates the first rooms
     */
    public RoomRepository() {
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
    }

    /**
     * save a new room to the
     */
    public Room saveRoom(Room room) {
        this.rooms.add(room);
        return room;
    }

    /**
     * this method updates the roomtype for an existing room
     *
     * @param roomNumber roomnumer of the room
     * @param roomType   new roomtype
     */
    public void updateRoom(int roomNumber, Enum<ERoomType> roomType) {
        for (Room room : this.rooms) {
            if (room.getNumber() == roomNumber) {
                room.setRoomType(roomType);
            }

        }

    }

    /**
     * this method deletes a room from the repository
     *
     * @param roomNumber # of room to delete
     */
    public void deleteRoom(int roomNumber) {
        for (Room room : this.rooms) {
            if (room.getNumber() == roomNumber) {
                rooms.remove(room);
            }

        }

    }

    /**
     * getter
     *
     * @return list of rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }
}
