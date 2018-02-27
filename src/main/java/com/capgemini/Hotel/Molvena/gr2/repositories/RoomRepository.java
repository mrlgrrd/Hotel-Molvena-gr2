package com.capgemini.Hotel.Molvena.gr2.repositories;

import com.capgemini.Hotel.Molvena.gr2.model.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

    /*// creation of list of rooms
    List<Room> rooms = new ArrayList<>();


    *//**
     * constructor generates the first rooms
     *//*
    public RoomRepository() {
        this.rooms = new ArrayList<>();
        Room room1 = new Room(ERoomType.STANDARD, 1);
        Room room2 = new Room(ERoomType.STANDARD, 2);
        Room room3 = new Room(ERoomType.DELUXE, 3);
        Room room4 = new Room(ERoomType.DELUXE, 4);
        Room room5 = new Room(ERoomType.HONEYMOON, 5);

        this.rooms.add(room1);
        this.rooms.add(room2);
        this.rooms.add(room3);
        this.rooms.add(room4);
        this.rooms.add(room5);
    }

    *//**
     * save a new room to the repository
     *//*
    public Room saveRoom(Room room) {
        this.rooms.add(room);
        return room;
    }

    *//**
     * update the properties of a room
     * @param roomToUpdate properties to update the room to
     *//*
    public void updateRoom(Room roomToUpdate) {
        for (Room room : this.rooms) {
            if (room.getNumber() == roomToUpdate.getNumber()) {
                room.setRoomType(roomToUpdate.getRoomType());
            }

        }

    }

    *//**
     * this method deletes a room from the repository
     *
     * @param roomNumber # of room to delete
     *//*
    public void deleteRoom(int roomNumber) {
        for (Room room : this.rooms) {
            if (room.getNumber() == roomNumber) {
                rooms.remove(room);
            }

        }

    }

    *//**
     * getter
     *
     * @return list of rooms
     *//*
    public List<Room> getRooms() {
        return rooms;
    }*/
}
