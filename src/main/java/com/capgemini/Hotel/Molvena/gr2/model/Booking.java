package com.capgemini.Hotel.Molvena.gr2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Booking implements Serializable {

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    //Variables
    private String guestID;

    @ManyToMany(mappedBy = "bookings")
    private List<Room> rooms;

    private String desiredPeriodFrom;
    private String desiredPeriodTill;

    //Getters & Setters
    public long getId() {
        return id;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public String getDesiredPeriodFrom() {
        return desiredPeriodFrom;
    }

    public void setDesiredPeriodFrom(String desiredPeriodFrom) {
        this.desiredPeriodFrom = desiredPeriodFrom;
    }

    public String getDesiredPeriodTill() {
        return desiredPeriodTill;
    }

    public void setDesiredPeriodTill(String desiredPeriodTill) {
        this.desiredPeriodTill = desiredPeriodTill;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
