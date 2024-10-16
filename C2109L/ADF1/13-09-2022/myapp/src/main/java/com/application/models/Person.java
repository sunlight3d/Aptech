package com.application.models;

public class Person {
    //fields
    private String name;//encapsulation
    private String nationality;
    private int birthYear;
    private float netWorth;
    //default constructor
    Person(){
        //no-arg constructors
        this.name = "";
        this.nationality = "Vietnam";
        //..
    }
    //full-parameters constructor
    public Person(String name, String nationality,
                  int birthYear, float netWorth) {
        this.name = name;
        this.nationality = nationality;
        this.birthYear = birthYear;
        this.netWorth = netWorth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public float getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(float netWorth) {
        this.netWorth = netWorth;
    }
}
