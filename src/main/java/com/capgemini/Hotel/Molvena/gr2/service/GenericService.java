package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import com.capgemini.Hotel.Molvena.gr2.model.ERoomType;
import com.capgemini.Hotel.Molvena.gr2.model.Price;
import com.capgemini.Hotel.Molvena.gr2.model.Room;
import com.capgemini.Hotel.Molvena.gr2.person.Guest;
import com.capgemini.Hotel.Molvena.gr2.repositories.BookingRepository;
import com.capgemini.Hotel.Molvena.gr2.repositories.GuestRepository;
import com.capgemini.Hotel.Molvena.gr2.repositories.PriceRepository;
import com.capgemini.Hotel.Molvena.gr2.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class GenericService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PriceRepository priceRepository;

    @PostConstruct
    public void init(){

        Booking b1 = new Booking();
        b1.setDesiredPeriodFrom("05-03-2018");
        b1.setDesiredPeriodTill("06-03-2018");
        this.bookingRepository.save(b1);

        Booking b2 = new Booking();
        b2.setDesiredPeriodFrom("07-03-2018");
        b2.setDesiredPeriodTill("08-03-2018");
        this.bookingRepository.save(b2);

        Guest guest1 = new Guest();
        guest1.setFirstname("Jeremy");
        guest1.setLastname("Jones");
        this.guestRepository.save(guest1);

        Guest guest2 = new Guest();
        guest2.setFirstname("Travis");
        guest2.setLastname("Rice");
        this.guestRepository.save(guest2);

        b2.setGuest(guest2);
        b1.setGuest(guest1);
        this.bookingRepository.save(b1);
        this.bookingRepository.save(b2);
        this.guestRepository.save(guest1);
        this.guestRepository.save(guest2);

        Room room1 = new Room();
        room1.setNumber(1);

        room1.setTheme("Red");
        room1.setRoomType(ERoomType.DELUXE);

        this.roomRepository.save(room1);

        Room room2 = new Room ();
        room2.setNumber(2);

        room2.setTheme("Green");
        room2.setRoomType(ERoomType.DELUXE);

        this.roomRepository.save(room2);

        Price price = new Price();
        price.setRoomPrice(79);
        this.priceRepository.save(price);

        room1.addBookingToRoom(b1);
        room2.addBookingToRoom(b2);
        b1.addRoomToBooking(room1);
        b2.addRoomToBooking(room2);

        this.bookingRepository.save(b2);
        this.bookingRepository.save(b1);
        this.roomRepository.save(room2);
        this.roomRepository.save(room1);


        Room room3 = new Room(ERoomType.STANDARD, 3);
        Room room4 = new Room(ERoomType.STANDARD, 4);
        Room room5 = new Room(ERoomType.DELUXE, 5);
        Room room6 = new Room(ERoomType.DELUXE, 6);
        Room room7 = new Room(ERoomType.HONEYMOON, 7);

        this.roomRepository.save(room3);
        this.roomRepository.save(room4);
        this.roomRepository.save(room5);
        this.roomRepository.save(room6);
        this.roomRepository.save(room7);









    }

}
