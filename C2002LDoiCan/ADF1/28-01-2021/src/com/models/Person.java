package com.models;

public class Person {
    String name = "";
    Integer age = 18;
    String email = "";
    final String hairColor = "black";
    /*
    {
        //initialization block
        name = "";
        age = 18;
        email = "";
        if(name == null) {

        }
        System.out.println("Day la khoi khoi tao");
    }

     */
    public Person() {
        System.out.println("This is constructor");
    }
}
