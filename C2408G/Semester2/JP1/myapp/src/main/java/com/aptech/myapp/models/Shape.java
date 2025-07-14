package com.aptech.myapp.models;

public abstract class Shape extends Object{
    protected String name;
    private String color;

    public abstract double getArea();//abstract

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
