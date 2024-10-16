package com.ab5tract.example;

public class Car extends Vehicle{
    private int numberOfDoors;

    public Car(String brand, String model, String registrationNumber, Person owner,
               int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return super.toString() + "numberOfDoors:"+numberOfDoors;
    }
}
