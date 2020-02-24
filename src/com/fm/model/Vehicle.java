package com.fm.model;

public class Vehicle {
    private int IDVehicle;
    private String Type;
    private String Maker;
    private int YearOfMaking;
    private int miles;

    public Vehicle() {
    }

    public Vehicle(int IDVehicle, String type, String maker, int yearOfMaking, int miles) {
        this.IDVehicle = IDVehicle;
        Type = type;
        Maker = maker;
        YearOfMaking = yearOfMaking;
        this.miles = miles;
    }

    public int getIDVehicle() {
        return IDVehicle;
    }

    public void setIDVehicle(int IDVehicle) {
        this.IDVehicle = IDVehicle;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getMaker() {
        return Maker;
    }

    public void setMaker(String maker) {
        Maker = maker;
    }

    public int getYearOfMaking() {
        return YearOfMaking;
    }

    public void setYearOfMaking(int yearOfMaking) {
        YearOfMaking = yearOfMaking;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }
}
