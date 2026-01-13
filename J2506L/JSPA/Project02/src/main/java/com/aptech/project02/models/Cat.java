package com.aptech.project02.models;
//"child" class = "sub" class
public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void say() {
        //super.say();
        System.out.println("Meoww");
    }

    @Override
    public String toString() {
        return "name is: "+this.name;
    }
}
