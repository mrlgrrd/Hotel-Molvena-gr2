package com.capgemini.Hotel.Molvena.gr2.person;

public class Guest extends Person {


    /**
     * Variables
     */
    private String address;
    private String zipCode;
    private String city;
    private String country;
    private int phone;
    private String email;
    private String passportNumber;
    private String nationality;

//    /**
//     * Methods
//     */
//    public void AddGuest(){
//
//    }
//
//    public void AlterGuest(){
//
//    }
//
//    public void SearchForGuest(){
//
//    }

    /**
     * Constructors
     */

    public Guest() {
    }

    /**
     * Getters and setters
     */
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
