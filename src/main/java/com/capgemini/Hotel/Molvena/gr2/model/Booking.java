package com.capgemini.Hotel.Molvena.gr2.model;
import com.capgemini.Hotel.Molvena.gr2.person.Guest;

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
    private String desiredPeriodFrom;
    private String desiredPeriodTill;

    @ManyToOne
    private Guest guest;

//    @ManyToMany(mappedBy = "bookings")
//    private List<Room> rooms;

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", desiredPeriodFrom='" + desiredPeriodFrom + '\'' +
                ", desiredPeriodTill='" + desiredPeriodTill + '\'' +
                ", guest=" + guest +
                '}';
    }

    //Getters & Setters

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public long getId() {
        return id;
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

//    public List<Room> getRooms() {
//        return rooms;
//    }
//
//    public void setRooms(List<Room> rooms) {
//        this.rooms = rooms;
//    }
}
