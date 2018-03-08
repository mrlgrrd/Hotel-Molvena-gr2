package com.capgemini.Hotel.Molvena.gr2.repositories;

import com.capgemini.Hotel.Molvena.gr2.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

    Iterable<Room> findByThemeContainingIgnoreCaseOrNumberContaining(String theme, int number);

    Iterable<Room> findByThemeContainingIgnoreCase(String theme);

    /**
     * select the room that had no bookings in the period requested, and qualifies on the other parameters
     * @param checkInDate check in date
     * @param checkOutDate check out date
     * @param nrOfBeds nr of beds
     * @param roomTheme room theme
     * @param roomType room type
     * @return list of rooms that qualify
     */
    //@Query("SELECT r FROM ROOM r LEFT OUTER JOIN ROOM_BOOKINGS rb ON (r.ID = rb.ROOMS_ID) LEFT OUTER JOIN BOOKING b ON (rb.BOOKINGS_ID = b.ID) WHERE ((b.desiredPeriodTill < (:checkInDate)) OR (b.desiredPeriodFrom > (:checkOutDate)) AND (r.nrOfPeople >= (:nrOfBeds)) AND (r.theme = (:roomTheme)) AND (r.roomType = (:roomType))")
    //Iterable<Room> selectRoomForBooking(@Param("checkInDate") Date checkInDate,@Param("checkOutDate") Date checkOutDate,@Param("nrOfBeds") int nrOfBeds,@Param("roomTheme") String roomTheme,@Param("roomType") String roomType);

}
