package com.capgemini.Hotel.Molvena.gr2;

import java.util.ArrayList;

public class Room {
    /**
     * properties
     */

    private Enum<ERoomType> roomType;

    private boolean occupied;

    private Price price;

    private BabyBed babybed;

    boolean isClean;

    ArrayList<Booking> roomBookings = new ArrayList<Booking>();

    private int number;

    private Enum<ERoomOccupiedBy> roomOccupiedBy;

    /**
     * constructor
     *
     * @param roomType room type
     * @param number   room nr
     */
    public Room(Enum<ERoomType> roomType, int number) {
        this.roomType = roomType;
        this.number = number;
        this.isClean = true;
        this.occupied = false;
    }

    /**
     * this method checks which rooms are available in a given period
     */
    public void checkIfAvailable() {

    }

    /**
     * this method lets you modify the properties of the room
     *
     * @param number    the room number
     * @param Eroomtype the room type
     */
    public void changeRoom(int number, Enum<ERoomType> Eroomtype) {
        this.roomType = Eroomtype;
        this.number = number;

    }

    /**
     * this method removes a room from the system
     */
    public void removeRoom() {

    }


}
