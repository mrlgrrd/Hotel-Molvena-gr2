package com.capgemini.Hotel.Molvena.gr2.repositories;

import com.capgemini.Hotel.Molvena.gr2.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

    ArrayList<Room> findByRoomTheme(String searchTheme);

}
