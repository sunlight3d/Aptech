package com.aptech.inheritance;

public class Rectangle extends Shape{
    //it can getName, getColor
    private int width, height;

    public Rectangle(String name, String color,
                     int width, int height) {
        super(name, color);//extends from super class
        this.width = width;
        this.height = height;
    }



    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        //You MUST implement abstract method from super class
        return width * height;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"+
                "width: "+width +"\n"+
                "height: "+height +"\n" +
                "area: "+this.getArea();
    }
}

