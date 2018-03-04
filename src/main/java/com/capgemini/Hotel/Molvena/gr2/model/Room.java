package com.capgemini.Hotel.Molvena.gr2.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room implements Serializable {
    /**
     * properties
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private ERoomType roomType;

    private boolean occupied;
    private String roomTheme;
    private int nrOfPeople;
    private boolean clean;
    private int number;

    @JsonIgnore
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Booking> bookings = new HashSet<>();

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


    public Set<Booking> getBookings() {
        return bookings;
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

    //Methode om persoon te adden aan set van snowboards
    public void addBooking (Booking booking){
        if(this.bookings == null){
            this.bookings = new HashSet<>();
        }
        this.bookings.add(booking);
        booking.getRooms().add(this);
    }
}
