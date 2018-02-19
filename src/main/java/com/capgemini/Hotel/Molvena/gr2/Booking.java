package com.capgemini.Hotel.Molvena.gr2;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;


import java.util.Date;

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

    private Employee employeeWhoBooked;

    private boolean isPaid;

    private String paymentType;

    /**
     * Constructor
     */
    public Booking(Guest guests, Room room, Date checkinDate, Date checkoutDate, boolean wantsBreakfast,
                   boolean wantsBabybed, Guest principleBooker, Employee employeeWhoBooked,
                   boolean isPaid, String paymentType) {
        this.guests = guests;
        this.room = room;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.wantsBreakfast = wantsBreakfast;
        this.wantsBabybed = wantsBabybed;
        this.principleBooker = principleBooker;
        this.employeeWhoBooked = employeeWhoBooked;
        this.isPaid = isPaid;
        this.paymentType = paymentType;
    }

    /**
     * methods
     */
    public void determineNightsOfStay(){}

    public void getPrice(){}

    public void checkRoomSize(){}

    public void makeBooking(){}

    public void cancelBooking(){}

    public void checkIfPaid(){}

    public void pay(){}



}
