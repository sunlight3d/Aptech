package com.aptech.project02.models;
//extends = inherits = ke thua
public class Student extends Person {
    //private String name;
    private String email;
    private int age;
    public Student(String name, String email, int age) {
        //All arguments constructor
        super.name = name;
        this.email = email;
        this.age = age;
    }
    public void setName(String name) {
        if(name.length() < 3) {
            System.err.println("Name must not be < 3 characters");
            return;
        }
        this.name = name;
    }
    public String getName() {
        return this.name.toUpperCase();
    }
}
