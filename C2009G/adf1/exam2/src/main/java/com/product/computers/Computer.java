package com.product.computers;

import com.product.Product;

public class Computer extends Product {
    private String speed;
    private String producer = "";

    public Computer() {
    }

    public Computer(String prodId, String prodName, int year, float price,
                    String speed, String producer) {
        super(prodId, prodName, year, price);
        this.speed = speed;
        this.producer = producer;
    }

    @Override
    public void input() {
        System.out.println("Enter product's id: ");
        this.prodId = getScanner().nextLine();

        System.out.println("Enter product's name: ");
        this.prodName = getScanner().nextLine();

        System.out.println("Enter product's year: ");
        this.year = getScanner().nextInt();

        System.out.println("Enter product's price: ");
        this.price = getScanner().nextFloat();

        System.out.println("Enter product's speed: ");
        this.speed = getScanner().nextLine();

        System.out.println("Enter product's producer: ");
        this.producer = getScanner().nextLine();
        
    }

    @Override
    public void display() {

    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
