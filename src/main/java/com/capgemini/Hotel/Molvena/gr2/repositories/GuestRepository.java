package com.capgemini.Hotel.Molvena.gr2.repositories;

import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface GuestRepository extends CrudRepository<Guest,Long> {
    List<Guest> findByFirstnameContainingIgnoreCaseOrPrepositionContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrZipCodeContainingIgnoreCaseOrCityContainingIgnoreCaseOrCountryContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrEmailContainingIgnoreCase(String searchFirstname, String searchPreposition, String searchLastname, String searchAddress, String searchZipCode, String searchCity, String searchCountry, String searchPhone, String searchEmail);
    //ArrayList<Guest> findByFirstnameContainingIgnoreCaseAndLastnameContainingIgnoreCase(String searchFirstname, String searchLastname);
    //ArrayList<Guest> findByFirstnameContainingIgnoreCaseAndPrepositionContainingIgnoreCaseAndLastnameContainingIgnoreCase(String searchFirstname,String searchPreposition, String searchLastname);

}
