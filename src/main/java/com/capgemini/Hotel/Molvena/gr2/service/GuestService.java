package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
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

    public Iterable<Guest> searchGuests(String searchValue){
        String searchWords[] = searchValue.split(" ");
        int numberWords = searchWords.length;
        Iterable<Guest> returnvalue = null;
        switch(numberWords){
            case 1: {
                returnvalue = this.guestRepository.findByFirstnameContainingIgnoreCase(searchWords[0]);
                break;
            }
            case 2: {
                returnvalue = this.guestRepository.findByFirstnameContainingIgnoreCaseAndLastnameContainingIgnoreCase(searchWords[0],searchWords[1]);
                break;
            }
            case 3: {
                returnvalue = this.guestRepository.findByFirstnameContainingIgnoreCaseAndPrepositionContainingIgnoreCaseAndLastnameContainingIgnoreCase(searchWords[0],searchWords[1],searchWords[2]);
                break;
            }
        }

        return returnvalue;
//        boolean removeRow;
//
//        Iterable<Guest> filteredList;
//        Iterable<Guest> temporaryList1 = guestRepository.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(searchWords[0], searchWords[0]);
//        for(int i = 1; i < searchWords.length; i++) {
//            Iterable<Guest> temporaryList2 = guestRepository.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(searchWords[i], searchWords[i]);
//            for(Guest guest1 : temporaryList1){
//                removeRow = true;
//                for(Guest guest2 : temporaryList2){
//                    if(guest1.equals(guest2)){
//                        filteredList.add(guest1);
//                    }
//                }
//                if(removeRow){ ;
//                }
//
//            }
//
//        }
//        return filteredList;
    }

    @Transactional
    public Guest addToGuest(Guest guest){
        this.guestRepository.save(guest);
        return guest;
    }

    @Transactional
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
