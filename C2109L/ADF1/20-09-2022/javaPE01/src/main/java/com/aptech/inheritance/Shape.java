package com.aptech.inheritance;

//parent class or super class
public abstract class Shape {
    private String name;
    private String color;

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    /*
    Sometime doc here
    * */
    public abstract int getArea(); //abstract method have no implementation
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", color='" + color + '\'';

    }
}
