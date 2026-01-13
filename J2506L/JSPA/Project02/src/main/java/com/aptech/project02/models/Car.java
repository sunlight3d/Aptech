package com.aptech.project02.models;

 public class Car {
    String name;
    String color;
    int year;
    public void display() {
        String color1 = "red";
        System.out.println("name = "+name+",color = "+color);
    }
    public void changeColor(String color) { //method with parameters
        this.color = color;
    }
    //default constructor = constructor without parameters
    public Car(){
        //No arguments constructor
        this.name = "";
        this.color = "";
    }
    //This is a constructor = ham khoi tao
    public Car(String name, String color) {
        //constructor with params = parameterized constructor
        this.name = name;
        this.color = color;
    }
    {
        //this is a block
        System.out.println("haha");
    }
    public Car(String name, String color, int year) {
        //constructor with params
        //All arguments constructor
        this.name = name;
        this.color = color;
        this.year = year;
    }
    private void functionA() {
        System.out.println("functionA");
    }
     private void functionB() {
         System.out.println("functionB");
     }
     public void functionX() {
         //many tasks ...
        functionA();
        //many tasks ...
        functionB();
     }
}
