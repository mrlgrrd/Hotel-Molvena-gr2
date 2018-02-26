package com.capgemini.Hotel.Molvena.gr2.repositories;
import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestRepository {



    private List<Guest> guests = new ArrayList<>();

    public GuestRepository(){
        this.guests = new ArrayList<>();
    }


    public Guest newGuest(Guest guest){
        this.guests.add(guest);
        return guest;
    }

    public List<Guest> getGuests() {
        return guests;
    }
}
