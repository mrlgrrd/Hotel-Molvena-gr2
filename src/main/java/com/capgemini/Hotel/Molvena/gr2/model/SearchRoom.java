package com.capgemini.Hotel.Molvena.gr2.model;

import java.util.Date;

public class SearchRoom {

    private Date checkIn;

    private Date checkOut;

    private String roomType;

    private int nrOfBeds;

    private String roomTheme;

    public SearchRoom() {
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getNrOfBeds() {
        return nrOfBeds;
    }

    public void setNrOfBeds(int nrOfBeds) {
        this.nrOfBeds = nrOfBeds;
    }

    public String getRoomTheme() {
        return roomTheme;
    }

    public void setRoomTheme(String roomTheme) {
        this.roomTheme = roomTheme;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
