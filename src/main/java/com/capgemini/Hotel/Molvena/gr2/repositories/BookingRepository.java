package com.capgemini.Hotel.Molvena.gr2.repositories;

import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{
    Iterable<Booking> findByGuest_id(long id);
    List<Booking> findByDesiredPeriodFromContainingIgnoreCaseOrDesiredPeriodTillContainingIgnoreCaseOrGuest_firstnameContainingIgnoreCaseOrRooms_themeContainingIgnoreCase(String searchDesiredPeriodFrom, String searchDesiredPeriodTill, String searchGuest_firstname, String searchRooms_theme);
}
