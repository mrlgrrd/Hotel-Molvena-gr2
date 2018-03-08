package com.capgemini.Hotel.Molvena.gr2.repositories;

import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{
    Iterable<Booking> findByGuest_id(long id);
    List<Booking> findByGuest_firstnameContainingIgnoreCaseOrGuest_prepositionContainingIgnoreCaseOrGuest_lastnameContainingIgnoreCaseOrGuest_emailContainingIgnoreCaseOrGuest_phoneContainingIgnoreCase(String searchGuest_firstname, String searchGuest_preposition, String searchGuest_lastname, String searchGuest_email, String searchGuest_phone);
}
