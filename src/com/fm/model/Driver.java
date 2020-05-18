package com.fm.model;

public class Driver {
    private String name;
    private String surname;
    private String phoneNumber;
    private String driversLicenseId;

    public Driver(String name, String surname, String phoneNumber, String driversLicenseId) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.driversLicenseId = driversLicenseId;
    }

    public Driver() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDriversLicenseId() {
        return driversLicenseId;
    }

    public void setDriversLicenseId(String driversLicenseId) {
        this.driversLicenseId = driversLicenseId;
    }
}
