package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.model.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.model.Room;
import com.capgemini.Hotel.Molvena.gr2.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @PostConstruct
    public void initializeRooms(){
        Room room1 = new Room(ERoomType.STANDARD, 1);
        Room room2 = new Room(ERoomType.STANDARD, 2);
        Room room3 = new Room(ERoomType.DELUXE, 3);
        Room room4 = new Room(ERoomType.DELUXE, 4);
        Room room5 = new Room(ERoomType.HONEYMOON, 5);

        roomRepository.save(room1);
        roomRepository.save(room2);
        roomRepository.save(room3);
        roomRepository.save(room4);
        roomRepository.save(room5);
    }

    public Iterable<Room> allRooms(){
        return this.roomRepository.findAll();
    }

    public Room selectRoomById(long id){
        return this.roomRepository.findOne(id);
    }

    public void deleteRoom(long id){
        this.roomRepository.delete(id);
    }
}
