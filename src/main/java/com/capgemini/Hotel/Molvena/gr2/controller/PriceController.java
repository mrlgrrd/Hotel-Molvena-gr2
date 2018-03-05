package com.capgemini.Hotel.Molvena.gr2.controller;

import com.capgemini.Hotel.Molvena.gr2.model.Price;
import com.capgemini.Hotel.Molvena.gr2.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pricecontroller/")
public class PriceController {

    @Autowired
    private PriceService priceService;

    public Iterable<Price> allPrices(){
        return priceService.allPrices();
    }
}
