package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

        Guest guest2 = new Guest();
        guest2.setFirstname("Jan");
        guest2.setPreposition("de");
        guest2.setLastname("Jong");

        this.guestRepository.save(guest2);
    }

    public Guest findById(long id){
        return this.guestRepository.findOne(id);
    }

    public Iterable<Guest> getGuests(){
        return this.guestRepository.findAll();
    }

    public Iterable<Guest> searchGuests(String searchValue){

//        int numberWords = searchWords.length;
//        ArrayList<Guest> returnvalue = null;
//        switch(numberWords){
//            case 1: {
//                returnvalue = this.guestRepository.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(searchWords[0],searchWords[0]);
//                break;
//            }
//            case 2: {
//                returnvalue = this.guestRepository.findByFirstnameContainingIgnoreCaseAndLastnameContainingIgnoreCase(searchWords[0],searchWords[1]);
//                break;
//            }
//            case 3: {
//                returnvalue = this.guestRepository.findByFirstnameContainingIgnoreCaseAndPrepositionContainingIgnoreCaseAndLastnameContainingIgnoreCase(searchWords[0],searchWords[1],searchWords[2]);
//                break;
//            }
//        }
//
//        return returnvalue;

        //All searchwords are divided by a space --> make an array with the different words
        String searchWords[] = searchValue.split(" ");
        //If the input is emptied, all guests should be shown again.
        if(searchValue.equals("")){
            getGuests();
        }
        boolean removeRow;

        //Make arraylists to work with
        List<Guest> temporaryList1 = new ArrayList<>();
        List<Guest> temporaryList2 = new ArrayList<>();
        List<Guest> filteredList = new ArrayList<>();

        //Get list of guests that would be found by the first searchword
        filteredList = guestRepository.findByFirstnameContainingIgnoreCaseOrPrepositionContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrZipCodeContainingIgnoreCaseOrCityContainingIgnoreCaseOrCountryContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrEmailContainingIgnoreCase(searchWords[0], searchWords[0], searchWords[0], searchWords[0], searchWords[0], searchWords[0], searchWords[0], searchWords[0], searchWords[0]);
        //Loop through the amount of searchwords
        for(int i = 1; i < searchWords.length; i++) {
            //temporaryList1 = (ArrayList<Guest>)filteredList.clone();
            temporaryList2 = guestRepository.findByFirstnameContainingIgnoreCaseOrPrepositionContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrZipCodeContainingIgnoreCaseOrCityContainingIgnoreCaseOrCountryContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrEmailContainingIgnoreCase(searchWords[i], searchWords[i], searchWords[i], searchWords[i], searchWords[i], searchWords[i], searchWords[i], searchWords[i], searchWords[i]);
            //You only want the guests that have to do with each searchword, so get rid of all results that do
            //not have to do with every result
            for(Guest guest1 : filteredList){
                removeRow = true;
                for(Guest guest2 : temporaryList2){
                    if(guest2.equals(guest1)){
                        removeRow = false;
                    }
                }
                //remove the guest from a temporary list
                if(removeRow){
                    temporaryList1.add(guest1);
                }

            }
            //Make the filtered list equal to the temporary list
            for(Guest rguest : temporaryList1) {
                filteredList.remove(rguest);
            }
            //filteredList = (ArrayList<Guest>)temporaryList1.clone();


        }
        //Only the guests that have to do with each searchword will be displayed on the screen
        return filteredList;
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
