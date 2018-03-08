package com.capgemini.Hotel.Molvena.gr2.service;
import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import com.capgemini.Hotel.Molvena.gr2.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    public Booking findById(long id){

    return this.bookingRepository.findOne(id);

    }

    public Iterable<Booking> allBookings(){
    return this.bookingRepository.findAll();

    }

    public Booking newBooking(Booking booking){
        this.bookingRepository.save(booking);
        return booking;
    }

    public Iterable<Booking> guestBooking(long id){
        return this.bookingRepository.findByGuest_id(id);
    }

    public Iterable<Booking> searchBooking(String searchValue){

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
            allBookings();
        }
        boolean removeRow;

        //Make arraylists to work with
        List<Booking> temporaryList1 = new ArrayList<>();
        List<Booking> temporaryList2 = new ArrayList<>();
        List<Booking> filteredList = new ArrayList<>();

        //Get list of guests that would be found by the first searchword
        filteredList = bookingRepository.findByGuest_firstnameContainingIgnoreCaseOrGuest_prepositionContainingIgnoreCaseOrGuest_lastnameContainingIgnoreCaseOrGuest_emailContainingIgnoreCaseOrGuest_phoneContainingIgnoreCase(searchWords[0], searchWords[0], searchWords[0] , searchWords[0] , searchWords[0]);
        //Loop through the amount of searchwords
        for(int i = 1; i < searchWords.length; i++) {
            //temporaryList1 = (ArrayList<Guest>)filteredList.clone();
            temporaryList2 = bookingRepository.findByGuest_firstnameContainingIgnoreCaseOrGuest_prepositionContainingIgnoreCaseOrGuest_lastnameContainingIgnoreCaseOrGuest_emailContainingIgnoreCaseOrGuest_phoneContainingIgnoreCase(searchWords[0], searchWords[0], searchWords[0], searchWords[0], searchWords[0]);
            //You only want the guests that have to do with each searchword, so get rid of all results that do
            //not have to do with every result
            for(Booking booking1 : filteredList){
                removeRow = true;
                for(Booking booking2 : temporaryList2){
                    if(booking2.equals(booking1)){
                        removeRow = false;
                    }
                }
                //remove the guest from a temporary list
                if(removeRow){
                    temporaryList1.add(booking1);
                }

            }
            //Make the filtered list equal to the temporary list
            for(Booking rbooking : temporaryList1) {
                filteredList.remove(rbooking);
            }
            //filteredList = (ArrayList<Guest>)temporaryList1.clone();


        }
        //Only the guests that have to do with each searchword will be displayed on the screen
        return filteredList;
    }
}
