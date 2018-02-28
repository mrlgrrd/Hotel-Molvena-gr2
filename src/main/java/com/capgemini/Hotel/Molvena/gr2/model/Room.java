package com.capgemini.Hotel.Molvena.gr2.model;

//import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.Hotel.Molvena.gr2.model.*;

import javax.persistence.*;
import java.util.ArrayList;

//@RequestMapping("/api/person/")
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

    private boolean occupied;

    private boolean clean;

    private int number;

   // private ERoomOccupiedBy roomOccupiedBy;

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
    }

    // empty constructor
    public Room() {
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
}
