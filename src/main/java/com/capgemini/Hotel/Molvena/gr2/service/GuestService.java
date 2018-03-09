package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.repositories.BookingRepository;
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

    @Autowired
    private BookingRepository bookingRepository;

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

        //All searchwords are divided by a space --> make an array with the different words
        String searchWords[] = searchValue.split(" ");
        //If the input is emptied, all guests should be shown again.
        if(searchValue.equals("")){
            getGuests();
        }
        boolean removeRow;

        //Make arraylists to work with
        List<Guest> temporaryList1 = new ArrayList<>();
        List<Guest> temporaryList2;
        List<Guest> filteredList;

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
    public Guest addGuest(Guest guest){
        String firstname = guest.getFirstname();
        String lastname = guest.getLastname();
        String phone = guest.getPhone();
        String email = guest.getEmail();
        boolean names = false;
        boolean contact = false;
        if(firstname == "") {
            guest.setFirstname(null);
        }
        if(lastname == ""){
            guest.setLastname(null);
        }
        if(phone == ""){
            guest.setPhone(null);
            phone = null;
        }
        if(email == ""){
            guest.setEmail(null);
            email = null;
        }
        if(firstname != null && lastname != null){
            names = true;
        }
        if(email != null || phone != null){
            contact = true;
        }
        if(names && contact) {
            this.guestRepository.save(guest);
        }
        return guest;
    }

    @Transactional
    public Guest updateGuest(long id, Guest updateGuest){
        Guest guest = this.guestRepository.findOne(id);
        if(updateGuest != null){
            guest.setFirstname(updateGuest.getFirstname());
            guest.setPreposition(updateGuest.getPreposition());
            guest.setLastname(updateGuest.getLastname());
            guest.setAddress(updateGuest.getAddress());
            guest.setZipCode(updateGuest.getZipCode());
            guest.setCity(updateGuest.getCity());
            guest.setCountry(updateGuest.getCountry());
            guest.setEmail(updateGuest.getEmail());
            guest.setPhone(updateGuest.getPhone());
            guest.setPassportNumber(updateGuest.getPassportNumber());
            guest.setNationality(updateGuest.getNationality());
        }
        String firstname = guest.getFirstname();
        String lastname = guest.getLastname();
        String phone = guest.getPhone();
        String email = guest.getEmail();
        boolean names = false;
        boolean contact = false;
        if(firstname == "") {
            guest.setFirstname(null);
        }
        if(lastname == ""){
            guest.setLastname(null);
        }
        if(phone == ""){
            guest.setPhone(null);
        }
        if(email == ""){
            guest.setEmail(null);
        }
        if(firstname != null && lastname != null){
            names = true;
        }
        if(email != null || phone != null){
            contact = true;
        }
        if(names && contact) {
            this.guestRepository.save(guest);
        }
        return guest;
    }

    @Transactional
    public void deleteGuest(Long id){
        this.guestRepository.delete(id);
    }

    public Guest findLastEntry(){

        Guest guest = this.guestRepository.findTopByOrderByIdDesc();
        return guest;
    }


}
