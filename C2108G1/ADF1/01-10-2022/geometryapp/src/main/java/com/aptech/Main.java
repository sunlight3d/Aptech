package com.aptech;

public class Main {
    public static void main(String[] args) {
        Point center1 = new Point(1, 3);
        Circle c1 = new Circle(12, center1);
        Point p1 = new Point(1, 3);
        Point p2 = new Point(4, 35);
        Point p3 = new Point(6, 9);

        Triangle triangle1 = new Triangle(p1, p2, p3);
        System.out.println("haha");
    }

}