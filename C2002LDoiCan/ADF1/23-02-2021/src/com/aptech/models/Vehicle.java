package com.aptech.models;

public class Vehicle {
    //public, private = access modifier
    public static Double MIN_PRICE = 10.0;
    private String name = "";
    private Double price = 0.0;//instance variables/fields
    private Double cylinderVolume = 0.0; //instance variables/fields

    public Vehicle(String name, Double price, Double cylinderVolume) {
        this.name = name;
        this.price = price;
        this.cylinderVolume = cylinderVolume;
    }
    //default constructor = constructor without parameters
    public Vehicle() {
        this.name = "";
        this.price = Vehicle.MIN_PRICE;
        this.cylinderVolume = 0.0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCylinderVolume() {
        return cylinderVolume;
    }

    public void setCylinderVolume(Double cylinderVolume) {
        this.cylinderVolume = cylinderVolume;
    }

    //private Double tax; //thuoc tinh nay co thuc su can ?? NO !
    public Double getTax() { //this is an "instance method"
        if(cylinderVolume < 100 && cylinderVolume >= 0) {
            return (1.00 / 100)*price;
        } else if(cylinderVolume >=100 && cylinderVolume <= 200) {
            return (3.00 / 100)*price;
        } else {
            return (5.00 / 100)*price;
        }
    }

}
