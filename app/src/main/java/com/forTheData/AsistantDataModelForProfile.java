package com.forTheData;

public class AsistantDataModelForProfile {


    private String name;
    private String address;
    private String phoneNumber;
    private String city;

    public AsistantDataModelForProfile(String name, String address, String phoneNumber, String city) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
