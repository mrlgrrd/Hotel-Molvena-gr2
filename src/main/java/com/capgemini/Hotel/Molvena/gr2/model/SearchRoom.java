package com.capgemini.Hotel.Molvena.gr2.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public class SearchRoom {

    private LocalDate checkIn;

    private LocalDate checkOut;

    @Enumerated(EnumType.STRING)
    private ERoomType roomType;

    private int nrOfBeds;

    private String roomTheme;

    public SearchRoom() {
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public ERoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(ERoomType roomType) {
        this.roomType = roomType;
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
}
