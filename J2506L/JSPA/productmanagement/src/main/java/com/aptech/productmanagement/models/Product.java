package com.aptech.productmanagement.models;

import java.util.Scanner;

public abstract class Product{
    protected String id;
    protected String name;
    protected double price;

    public Product() {

    }
    public abstract double getFinalPrice();

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    private Scanner getScanner() {
        return new Scanner(System.in);
    }
    public void input() {
        System.out.println("Enter id: ");
        String id = getScanner().next();
        this.setId(id);
        update();
    }
    public void update() {

        System.out.println("Enter name: ");
        String name = getScanner().next();

        System.out.println("Enter price: ");
        double price = (new Scanner(System.in)).nextDouble();
        this.setName(name);
        this.setPrice(price);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "id='" + id +
                ", name='" + name +
                ", price=" + price + " ";

    }
}
