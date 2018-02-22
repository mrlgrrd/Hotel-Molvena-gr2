package com.capgemini.Hotel.Molvena.gr2;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;


import java.util.Date;

/**
 * POJO
 */

public class Booking {

    /**
     * Variables
     */
    private Guest guests;

    private Room room;

    private Date checkinDate;

    private Date checkoutDate;

    private int nightsOfStay;

    private Price price;

    private boolean wantsBreakfast;

    private boolean wantsBabybed;

    private Guest principleBooker;

    //Employee is nu verwijderd, heet nu controller, die moet straks worden toegevoegd in de constructor hieronder
//    private Employee employeeWhoBooked;

    private boolean isPaid;

    private String paymentType;

    /**
     * Constructor
     */
    public Booking(Guest guests, Room room, Date checkinDate, Date checkoutDate, boolean wantsBreakfast,
                   boolean wantsBabybed, Guest principleBooker,
                   boolean isPaid, String paymentType) {
        this.guests = guests;
        this.room = room;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.wantsBreakfast = wantsBreakfast;
        this.wantsBabybed = wantsBabybed;
        this.principleBooker = principleBooker;
//        this.employeeWhoBooked = employeeWhoBooked;
        this.isPaid = isPaid;
        this.paymentType = paymentType;
    }

    /**
     * default constructor
     */
    public Booking() {
    }

    /**
     * Getters & Setters
     */

    public Guest getGuests() {
        return guests;
    }

    public void setGuests(Guest guests) {
        this.guests = guests;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getNightsOfStay() {
        return nightsOfStay;
    }

    public void setNightsOfStay(int nightsOfStay) {
        this.nightsOfStay = nightsOfStay;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public boolean isWantsBreakfast() {
        return wantsBreakfast;
    }

    public void setWantsBreakfast(boolean wantsBreakfast) {
        this.wantsBreakfast = wantsBreakfast;
    }

    public boolean isWantsBabybed() {
        return wantsBabybed;
    }

    public void setWantsBabybed(boolean wantsBabybed) {
        this.wantsBabybed = wantsBabybed;
    }

    public Guest getPrincipleBooker() {
        return principleBooker;
    }

    public void setPrincipleBooker(Guest principleBooker) {
        this.principleBooker = principleBooker;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
