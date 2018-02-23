package com.capgemini.Hotel.Molvena.gr2;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@RequestMapping("/api/person/")
public class Room {
    /**
     * properties
     */
    private ERoomType roomType;

    private boolean occupied;

    private Price price;

    private BabyBed babybed;

    private boolean isClean;

   private ArrayList<Booking> roomBookings = new ArrayList<Booking>();

    private int number;

    private ERoomOccupiedBy roomOccupiedBy;

    /**
     * constructor
     *
     * @param roomType room type
     * @param number   room nr
     */
    public Room(ERoomType roomType, int number) {
        this.roomType = roomType;
        this.number = number;
        this.isClean = true;
        this.occupied = false;
    }

    // empty constructor
    public Room() {
    }

    /**
     * getters & setters
     * @return value
     */

    public ERoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(ERoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public BabyBed getBabybed() {
        return babybed;
    }

    public void setBabybed(BabyBed babybed) {
        this.babybed = babybed;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public ArrayList<Booking> getRoomBookings() {
        return roomBookings;
    }

    public void setRoomBookings(ArrayList<Booking> roomBookings) {
        this.roomBookings = roomBookings;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ERoomOccupiedBy getRoomOccupiedBy() {
        return roomOccupiedBy;
    }

    public void setRoomOccupiedBy(ERoomOccupiedBy roomOccupiedBy) {
        this.roomOccupiedBy = roomOccupiedBy;
    }
}
