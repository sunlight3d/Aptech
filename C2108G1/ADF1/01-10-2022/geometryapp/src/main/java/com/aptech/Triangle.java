package com.aptech;

public class Triangle implements GeometricObject{
    private Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }
    public boolean isTriangle() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        return  (a + b > c) && (a + c > b) && (c + b > a);
    }
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    @Override
    public double getArea() {
        double p = this.getPerimeter() / 2;
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        return Math.sqrt(p * (p - a) * (p - b)*(p - c));
    }

    @Override
        public double getPerimeter() {
            return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    @Override
    public String getInfo() {
        return null;
    }
}
