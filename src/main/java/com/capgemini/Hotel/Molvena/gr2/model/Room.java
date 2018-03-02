package com.capgemini.Hotel.Molvena.gr2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
    /**
     * properties
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private ERoomType roomType;

    @ManyToMany
    private List<Booking> bookings;

    private boolean occupied;

    private String roomTheme;

    private int nrOfPeople;

    private boolean clean;

    private int number;

    // private ERoomOccupiedBy roomOccupiedBy;

    public Room() {
    }

    /**
     * constructor
     *
     * @param roomType room type
     * @param number   room nr
     */
    public Room(ERoomType roomType, int number) {
        this.roomType = roomType;
        this.number = number;
        this.clean = true;
        this.occupied = false;
        this.nrOfPeople = 2;
    }


    /**
     * getters & setters
     *
     * @return value
     */

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isClean() {
        return this.clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public ERoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(ERoomType roomType) {
        this.roomType = roomType;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getNrOfPeople() {
        return nrOfPeople;
    }

    public void setNrOfPeople(int nrOfPeople) {
        this.nrOfPeople = nrOfPeople;
    }

    public String getRoomTheme() {
        return roomTheme;
    }

    public void setRoomTheme(String roomTheme) {
        this.roomTheme = roomTheme;
    }
}
