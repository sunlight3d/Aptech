package models;

import java.util.Scanner;

public class Rectangle {
    private Float width;
    private Float height;
    //constructor with params
    public Rectangle(Float width, Float height) {
        this.width = width;
        this.height = height;
    }
    //overloading
    public Rectangle(Float width) {
        this.width = width;
        this.height = 0.0f;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }
    public Float getArea() {
        return width * height;
    }
    public Float getPerimeter() {
        return 2*(this.width + this.height);
    }
    public static Rectangle input(){
        //Factory method
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width = ");
        Float width = scanner.nextFloat();
        System.out.println("Enter height = ");
        Float height = scanner.nextFloat();
        Rectangle rectangle = new Rectangle(width, height);
//        rectangle.setWidth(width);//co 100 thuoc tinh thi sao ?
//        rectangle.setHeight(height);//can constructor co tham so(params)
        return rectangle;
    }
}
