package com.aptech.project02.models;
//"child" class = "sub" class
public class Dog extends Animal{
    protected int numberOfLegs;
    public Dog(String name, int numberOfLegs) {
        super(name);
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public void say() {
        //super.say();
        System.out.println("go go");
    }
    @Override
    public String toString() {
        return "name is: "+this.name;
    }
}
