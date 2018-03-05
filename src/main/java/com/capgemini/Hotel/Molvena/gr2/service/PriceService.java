package com.capgemini.Hotel.Molvena.gr2.service;

import com.capgemini.Hotel.Molvena.gr2.model.Price;
import com.capgemini.Hotel.Molvena.gr2.repositories.BookingRepository;
import com.capgemini.Hotel.Molvena.gr2.repositories.PriceRepository;
import com.capgemini.Hotel.Molvena.gr2.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PriceRepository priceRepository;

    /**
     * constructor
     */
    public PriceService() {
    }

    /**
     * methods
     */
    public Iterable<Price> allPrices(){
        return this.priceRepository.findAll();
    }

}
