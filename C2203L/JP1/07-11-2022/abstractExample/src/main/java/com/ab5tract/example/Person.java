package com.ab5tract.example;

import java.util.ArrayList;

public class Person {
    private String idCard;
    private String name;
    private String address;
    //private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();//eager init
    private ArrayList<Vehicle> vehicles = null; //lazy int

    public Person(String idCard, String name, String address) {
        this.idCard = idCard;
        this.name = name;
        this.address = address;
    }

    public ArrayList<Vehicle> getVehicles() {
        //return vehicles;//eager init
        //lazy init
        if(vehicles == null) {
            vehicles = new ArrayList<Vehicle>();
        }
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
