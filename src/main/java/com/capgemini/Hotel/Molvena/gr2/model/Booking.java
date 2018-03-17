package com.capgemini.Hotel.Molvena.gr2.model;
import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Booking implements Serializable {

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    //Variables
    private LocalDate desiredPeriodFrom;
    private LocalDate desiredPeriodTill;

    @ManyToOne
    private Guest guest;

    @ManyToMany(mappedBy = "bookings", fetch = FetchType.EAGER)
    private Set<Room> rooms = new HashSet<>();

    @ManyToMany(mappedBy = "bookings", fetch = FetchType.EAGER)
    private Set<Price> prices = new HashSet<>();

//    @ManyToMany(mappedBy = "bookings")
//    private List<Room> rooms;

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", desiredPeriodFrom='" + desiredPeriodFrom + '\'' +
                ", desiredPeriodTill='" + desiredPeriodTill + '\'' +
                ", guest=" + (guest !=null ? guest.getLastname() : "empty") +
                '}';
    }

    //Getters & Setters
    public Set<Room> getRooms() {
        return rooms;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDesiredPeriodFrom() {
        return desiredPeriodFrom;
    }

    public void setDesiredPeriodFrom(LocalDate desiredPeriodFrom) {
        this.desiredPeriodFrom = desiredPeriodFrom;
    }

    public LocalDate getDesiredPeriodTill() {
        return desiredPeriodTill;
    }

    public void setDesiredPeriodTill(LocalDate desiredPeriodTill) {
        this.desiredPeriodTill = desiredPeriodTill;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }

    //    public List<Room> getRooms() {
//        return rooms;
//    }
//
//    public void setRooms(List<Room> rooms) {
//        this.rooms = rooms;
//    }

    public void addRoomToBooking(Room room){
        if(this.rooms == null){
            this.rooms = new HashSet<>();
        }
        this.rooms.add(room);
        room.getBookings().add(this);
    }

    public void addPriceToBooking(Price price){
        if(this.prices == null){
            this.prices = new HashSet<>();
        }
        this.prices.add(price);
        price.getBookings().add(this);
    }
}
