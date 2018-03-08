package com.capgemini.Hotel.Molvena.gr2.data;

import com.capgemini.Hotel.Molvena.gr2.model.Booking;

public class BookingModel {

    private Booking booking;
    private long guestId;
    private long[] roomIds;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public long[] getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(long[] roomId) {
        this.roomIds = roomId;
    }
}
