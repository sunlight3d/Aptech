package models;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public abstract class Shape {
    private String name;
    private String color;
    //default constructor
    public Shape() {

    }
    //ham khoi tao(full arguments)
    public Shape(String name, String color){
        this.name = name;
        this.color = color;
    }
    public void funcA() {
        System.out.println("This is function A");
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
    //abstract = "unfinished" = chi co ten, ko co phan thuc thi(implementation)
    public abstract Float getArea(); //dien tich hinh bat ky => ko tinh duoc
    public abstract Float getPerimeter();
    //phuong thuc nay ko du dieu kien de thuc thi
}
//class Rectangle co thuoc tinh: (name, color), width, height
//class Circle co thuoc tinh: (name, color), radius
//Tao doi tuong Shape(name, color)
//Rectangle la con(child class, sub class) cua Shape(chi can them width, height)
//Circle la con(child class, sub class) cua Shape(chi can them radius)
//Rectangle ke thua(inherite, extends) tu Shape
//Circle ke thua tu Shape(lop cha = parent class, super class)

