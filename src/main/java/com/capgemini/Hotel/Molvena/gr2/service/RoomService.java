package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.model.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.model.Room;
import com.capgemini.Hotel.Molvena.gr2.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;


    // default constructor
    public RoomService() {
    }

    /**
     * this method returns a list of all rooms
     * @return list of all rooms
     * */
    public Iterable<Room> allRooms(){
        return this.roomRepository.findAll();
    }

    /**
     * 
     * @param id
     * @return
     */
    public Room selectRoomById(Long id){
        return this.roomRepository.findOne(id);
    }

    public void deleteRoom(Long id){
        this.roomRepository.delete(id);
    }

    public void addRoom(Room room){
        this.roomRepository.save(room);
    }

    public Room findRoomById(Long id){
        return this.roomRepository.findOne(id);
    }

    public void updateRoom(Room room){
        this.roomRepository.save(room);
    }

    public Iterable<Room> searchRoomTheme(String searchRooms){
        String searchRoomList[] = searchRooms.split(" ");
        int numberWords = searchRoomList.length;

        Iterable<Room> foundRooms = null;

        switch(numberWords){
            case 1: {
                foundRooms = this.roomRepository.findByRoomTheme(searchRoomList[0]);
                break;
            }
            case 2: {
                foundRooms = this.roomRepository.findByRoomTheme(searchRoomList[1]);
                break;
            }
            case 3: {
                foundRooms = this.roomRepository.findByRoomTheme(searchRoomList[2]);
                break;
            }
        }
        return foundRooms;
    }
}
