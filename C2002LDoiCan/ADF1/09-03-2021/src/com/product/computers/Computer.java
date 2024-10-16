package com.product.computers;

import com.product.Product;

import java.util.Scanner;

public class Computer extends Product {
    private String speed;
    private String producer;
    public Computer(){
        super();
        //constructor no arguments
        speed = "";
        producer = "";
    }

    public Computer(String productId, String productName, int year, float price,
                    String speed, String producer) {
        super(productId, productName, year, price);
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
        Scanner scanner = new Scanner(System.in);
        //Nhap thong tin cua Product
        System.out.println("Enter product's id: ");
        this.productId = scanner.nextLine();

        System.out.println("Enter product's name: ");
        this.productName = scanner.nextLine();

        System.out.println("Enter product's year: ");
        this.year = scanner.nextInt();

        System.out.println("Enter product's price: ");
        this.price = scanner.nextFloat();
        //Nhap thong tin cua Computer
        System.out.println("Enter computer's speed: ");
        this.speed = scanner.nextLine();
    }

    @Override
    public void display() {
        System.out.println("id = "+this.productId+
                "name = "+this.productName+
                "year = "+String.valueOf(this.year)+
                "price = "+String.valueOf(this.price)+
                "speed = "+this.speed+
                "producer = "+this.producer
        );
    }
}
