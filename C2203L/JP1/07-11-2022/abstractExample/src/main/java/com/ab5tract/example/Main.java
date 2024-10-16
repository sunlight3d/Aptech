package com.ab5tract.example;
public class Main {
    public static void main(String[] args) {
        //Vehicle vehicle = new Vehicle();//cannot init an object from an abstract class
        Person mrHoang = new Person("id112", "Nguyen Duc Hoang", "hanoi");
        System.out.println("haha");
        Vehicle motobike = new Motobike(
                "Honda",
                "hrsx red",
                "x12334",
                mrHoang,
                true);
        mrHoang.getVehicles().add(motobike);
        Vehicle carMercedes = new Car(
                "Mec",
                "g63",
                "hhuhd11221",
                mrHoang,
                2
        );
        mrHoang.getVehicles().add(carMercedes);
    }
}