package com.aptech.myapp.models;

public class Rectangle extends Shape{
    protected float width;
    protected float height;

    @Override
    public double getArea() { //phương thức abstract bắt buộc lớp con phải overide
        return width * height;
    }


    @Override
    public String toString() { //Ko bắt buộc vì toString ko phải là abstract method
        System.out.println(super.name);//vì name là protected
        //System.out.println(this.color)//ko dc vì color ko phải public/protected;
        System.out.println(super.getColor());
        return super.toString();
    }

}
