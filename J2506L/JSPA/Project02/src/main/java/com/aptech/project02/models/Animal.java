package com.aptech.project02.models;
//Animal is "parent"/"super" class
public class Animal {
    protected String name;
    //instance method
    protected void say() {
        System.out.println("Animal say something...");
    }
    public Animal(String name) {
        this.name = name;
    }
}
