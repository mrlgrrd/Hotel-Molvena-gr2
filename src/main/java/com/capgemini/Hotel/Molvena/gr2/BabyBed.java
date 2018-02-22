package com.capgemini.Hotel.Molvena.gr2;

public class BabyBed {

    /**
     * properties
     */

    private boolean inUse;

    private boolean clean;

    private int inRoomNr;

    /**
     * constructors
     */
    public BabyBed() {
        this.clean = true;
        this.inUse = false;
    }


    /**
     * this method assigns a babybed to a room
     *
     * @param roomNr
     */
    public void assignToRoom(int roomNr) {
        this.inUse = true;
        this.clean = false;
        this.inRoomNr = roomNr;

    }

    /**
     * this method sets the babybed to clean
     */
    public void cleanBabyBed() {
        this.clean = true;
    }

}
