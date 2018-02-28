package com.capgemini.Hotel.Molvena.gr2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Booking implements Serializable {

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    //Variables
    private String guestID;
    private String roomID;
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

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
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
}
