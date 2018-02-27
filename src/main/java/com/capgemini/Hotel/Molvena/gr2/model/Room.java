package com.capgemini.Hotel.Molvena.gr2.model;

//import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.Hotel.Molvena.gr2.model.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

  //  private ERoomType roomType;

    private boolean occupied;

    private boolean Clean;

    private int number;

   // private ERoomOccupiedBy roomOccupiedBy;

    /**
     * constructor
     *
     * @param roomType room type
     * @param number   room nr
     */
    /*public Room(ERoomType roomType, int number) {
        this.roomType = roomType;
        this.number = number;
        this.Clean = true;
        this.occupied = false;
    }*/

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
        return Clean;
    }

    public void setClean(boolean clean) {
        Clean = clean;
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
}
