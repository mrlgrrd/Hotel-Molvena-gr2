package com.capgemini.Hotel.Molvena.gr2.repositories;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GuestRepository extends CrudRepository<Guest,Long> {
    ArrayList<Guest> findByFirstnameContainingIgnoreCase(String searchFirstname);
    ArrayList<Guest> findByFirstnameContainingIgnoreCaseAndLastnameContainingIgnoreCase(String searchFirstname, String searchLastname);
    ArrayList<Guest> findByFirstnameContainingIgnoreCaseAndPrepositionContainingIgnoreCaseAndLastnameContainingIgnoreCase(String searchFirstname,String searchPreposition, String searchLastname);
}
