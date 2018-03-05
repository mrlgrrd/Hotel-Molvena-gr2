package com.capgemini.Hotel.Molvena.gr2.person;

import com.capgemini.Hotel.Molvena.gr2.model.Booking;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Guest implements Serializable{


    /**
     * Variables
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@NotNull
    private String firstname;

    private String preposition;

    //@NotNull
    private String lastname;

    private String address;
    private String zipCode;
    private String city;
    private String country;
    private String phone;

    //@NotNull
    private String email;

    private String passportNumber;
    private String nationality;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy= "guest")
    private Set<Booking> bookings;

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", preposition='" + preposition + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", bookings=" + bookings +
                '}';
    }


    /**
     * Constructors
     */

    public Guest() {
    }

    public Guest(String country, String city) {
        this.country = country;
        this.city = city;

    }



    /**
     * Getters and setters
     */

    public Set<Booking> getBookings() {
        return bookings;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPreposition() {
        return preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
