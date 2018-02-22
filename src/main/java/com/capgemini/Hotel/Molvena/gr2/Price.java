package com.capgemini.Hotel.Molvena.gr2;

import java.util.Date;

public class Price {

    /**
     * Variables
     */
    private ERoomType roomtype;

    private double roomPrice;

    private int nightsOfStay;

    //fromDateSeason and untilDateSeason are used to set different prices on different times of the year
    private Date fromDateSeason;

    private Date UntilDateSeason;

    private double Discount;

    /**
     * Constructor
     */

    public Price(){

    }

    /**
     * Methods
     */
    public void constructPrice(){}

    public void updatePrice(){}

    /**
     * Getters & Setters
     * @return
     */

    public ERoomType getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(ERoomType roomtype) {
        this.roomtype = roomtype;
    }

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
}
