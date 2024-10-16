package com.aptech;

import com.aptech.inheritance.Circle;
import com.aptech.inheritance.Rectangle;
import com.aptech.inheritance.Shape;
import com.aptech.temp.MyPrintStream;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Question01 question01 = new Question01();
        int wordCount = question01.countWord("Welcome to Aptech");
        //System.out.println("Number of words is: "+wordCount);

//        System.out.println(String.format("Number of words is: %d", wordCount));
//        StudentManager studentManager = new StudentManager();
//        studentManager.inputStudents();
//        studentManager.showAllStudents();

//        PrintStream out = System.out;
//        out.println("hehe");
        MyPrintStream.println("chao cac ban", false);
        MyPrintStream.println("cai nay de test");
        Rectangle rectangle1 = new Rectangle("hinh chu nhat A",
                "red", 10, 20);
        Rectangle rectangle2 = new Rectangle("hinh chu nhat B",
                "green", 20, 30);
        System.out.println(rectangle1.toString());
        System.out.println(rectangle2.toString());
        //Shape shape1 = new Shape("hinh dang", "yellow");//abstract cannot be instantiated
        //You can reference a super object to child object
        Shape rectangle3 = new Rectangle("hinh C", "yellow", 25, 30);//ok
        System.out.println("Dien tich cua C la : "+rectangle3.getArea());
        Circle circle1 = new Circle("hisnh tron A", "blue", 12);
        System.out.println(circle1);
        ArrayList<Shape> someShapes = new ArrayList<>();
        someShapes.add(rectangle1);
        someShapes.add(rectangle2);
        someShapes.add(rectangle3);
        someShapes.add(circle1);
        for (Shape shape: someShapes) {
            System.out.println(shape instanceof Rectangle ?
                    "This is rectangle" : (shape instanceof Circle ? "This is circle" : "Unknown"));
            /*
            if(shape instanceof Rectangle) {
                System.out.println("This is rectangle");
            } else if(shape instanceof Circle) {
                System.out.println("This is circle");
            }
             */
        }

    }
}