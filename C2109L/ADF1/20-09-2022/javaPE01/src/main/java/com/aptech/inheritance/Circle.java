package com.aptech.inheritance;

public class Circle extends Shape{
    private int radius;

    public Circle(String name, String color, int radius) {
        super(name, color);
        this.radius = radius;
    }

    @Override
    public int getArea() {
        return (int)Math.PI * radius * radius;//explicit casting
    }
    public double getFloatArea() {
        return Math.PI * radius * radius;//explicit casting
    }

    @Override
    public String toString() {
        return super.toString() + "\n"+
                "radius=" + radius + "\n"+
                "area = "+this.getArea();

    }
}
