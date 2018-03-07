package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.model.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.model.Room;
import com.capgemini.Hotel.Molvena.gr2.model.SearchRoom;
import com.capgemini.Hotel.Molvena.gr2.repositories.BookingRepository;
import com.capgemini.Hotel.Molvena.gr2.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;


    // default constructor
    public RoomService() {
    }

    /**
     * this method returns a list of all rooms
     *
     * @return list of all rooms
     */
    public Iterable<Room> allRooms() {
        return this.roomRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    public Room selectRoomById(Long id) {
        return this.roomRepository.findOne(id);
    }

    public void deleteRoom(Long id) {
        this.roomRepository.delete(id);
    }

    public void addRoom(Room room) {
        this.roomRepository.save(room);
    }

    public Room findRoomById(Long id) {
        return this.roomRepository.findOne(id);
    }

/*    public void updateRoom(Room room){
        this.roomRepository.save(room);
    }*/

    public Iterable<Room> searchRoomTheme(String theme) {
        String searchRoomList[] = theme.split(" ");

        if (theme.equals("")) {
            allRooms();
        }

        int numberWords = searchRoomList.length;

        Iterable<Room> foundRooms = null;

        switch (numberWords) {
            case 1: {
                foundRooms = this.roomRepository.findByThemeContainingIgnoreCase(searchRoomList[0]);
                break;
            }
            case 2: {
                foundRooms = this.roomRepository.findByThemeContainingIgnoreCase(searchRoomList[1]);
                break;
            }
            case 3: {
                foundRooms = this.roomRepository.findByThemeContainingIgnoreCase(searchRoomList[2]);
                break;
            }
        }
        return foundRooms;
    }

    public void updateRoom(long id, Room updateRoom) {
        Room room = this.roomRepository.findOne(id);
        if (room != null) {
            room.setRoomType(updateRoom.getRoomType());
            room.setNumber(updateRoom.getNumber());
            room.setTheme(updateRoom.getTheme());
            room.setOccupied(updateRoom.isOccupied());
            room.setClean(updateRoom.isClean());
            room.setNrOfPeople(updateRoom.getNrOfPeople());
            this.roomRepository.save(room);
        }

    }

    public Iterable<Room> selectRoomForBooking(SearchRoom searchRoom) {
        Date checkInDate = searchRoom.getCheckIn();
        Date checkOutDate = searchRoom.getCheckOut();
        int nrOfBeds = searchRoom.getNrOfBeds();
        String roomType = searchRoom.getRoomType();
        String roomTheme = searchRoom.getRoomTheme();

        return this.roomRepository.selectRoomForBooking(checkInDate,checkOutDate, nrOfBeds, roomTheme, roomType);

    }
}
