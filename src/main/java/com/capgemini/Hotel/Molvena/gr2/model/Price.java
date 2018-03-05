package com.capgemini.Hotel.Molvena.gr2.model;

import com.capgemini.Hotel.Molvena.gr2.model.ERoomType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Price {
     /**
     * Variables
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    private Set<Booking> bookings;

    private double roomPrice;

    private int nightsOfStay;

    //fromDateSeason and untilDateSeason are used to set different prices on different times of the year
    private Date fromDateSeason;

    private Date UntilDateSeason;

    // discount percentage
    private double Discount;

    /**
     * Constructor
     */

    public Price(){
    }

    public Price(double roomPrice, Date fromDateSeason, Date untilDateSeason) {
        this.roomPrice = roomPrice;
        this.fromDateSeason = fromDateSeason;
        UntilDateSeason = untilDateSeason;
    }

    /**
     * Methods
     */
    public void constructPrice(){}

    public void newPrice(){}

    /**
     * Getters & Setters
     * @return
     */

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getNightsOfStay() {
        return nightsOfStay;
    }

    public void setNightsOfStay(int nightsOfStay) {
        this.nightsOfStay = nightsOfStay;
    }

    public Date getFromDateSeason() {
        return fromDateSeason;
    }

    public void setFromDateSeason(Date fromDateSeason) {
        this.fromDateSeason = fromDateSeason;
    }

    public Date getUntilDateSeason() {
        return UntilDateSeason;
    }

    public void setUntilDateSeason(Date untilDateSeason) {
        UntilDateSeason = untilDateSeason;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public long getId() {
        return id;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
