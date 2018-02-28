package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @PostConstruct
    public void init(){
        Guest guest1 = new Guest();
        guest1.setFirstname("Henk");
        guest1.setLastname("Jansen");

        this.guestRepository.save(guest1);
    }

    public Guest findById(long id){
        return this.guestRepository.findOne(id);
    }

    public Iterable<Guest> getGuests(){
        return this.guestRepository.findAll();
    }

    public Guest newGuest(Guest guest){
        this.guestRepository.save(guest);
        return guest;
    }

    public void deleteGuest(Long id){
        this.guestRepository.delete(id);
    }

    //package com.capgemini.Hotel.Molvena.gr2.repositories;
//import com.capgemini.Hotel.Molvena.gr2.person.Guest;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class GuestRepository {
//
//
//
//    private List<Guest> guests = new ArrayList<>();
//
//    public GuestRepository(){
//        this.guests = new ArrayList<>();
//    }
//
//
//    public Guest newGuest(Guest guest){
//        this.guests.add(guest);
//        return guest;
//    }
//
//    public List<Guest> getGuests() {
//        return guests;
//    }
//}


}
