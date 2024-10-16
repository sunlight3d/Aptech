package com.product.computers;

import com.product.Product;

import java.util.Scanner;

public class Computer extends Product {
    private String speed;
    private String producer;
    public Computer() {

    }

    public Computer(String prodId, String prodName, int year, float price,
                    String speed, String producer) {
        super(prodId, prodName, year, price);//constructor of parent class
        this.speed = speed;
        this.producer = producer;
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

    @Override
    public void input() {
        System.out.println("Enter product's id : ");
        this.prodId = (new Scanner(System.in)).next();

        System.out.println("Enter product's name : ");
        this.prodName = (new Scanner(System.in)).next();

        System.out.println("Enter product's year : ");
        this.year = (new Scanner(System.in)).nextInt();

        System.out.println("Enter product's price : ");
        this.price = (new Scanner(System.in)).nextFloat();

        System.out.println("Enter computer's speed : ");
        this.speed = (new Scanner(System.in)).next();

        System.out.println("Enter producer : ");
        this.producer = (new Scanner(System.in)).next();
    }

    @Override
    public void display() {
        System.out.println(
                "id: "+this.prodId+
                "name: "+this.prodName+
                "id: "+this.year+
                "id: "+this.price+
                "id: "+this.speed+
                "id: "+this.producer);
    }


}
