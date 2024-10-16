package com.product.computers;

import com.product.Helper;
import com.product.Product;

import static com.product.Helper.getScanner;

public class Computer extends Product {
    private String speed;
    private String produder;

    public Computer() {

    }

    public Computer(String proId, String proName, int year, float price,
                    String speed, String producer) {
        super(proId, proName, year, price);
        this.speed = speed;
        this.produder = producer;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getProduder() {
        return produder;
    }

    public void setProduder(String produder) {
        this.produder = produder;
    }

    @Override
    public void input() {
        System.out.println("Enter productId: ");
        this.proId = getScanner().nextLine();

        System.out.println("Enter product's name: ");
        this.proName = getScanner().nextLine();

        System.out.println("Enter product's year: ");
        this.year = Integer.parseInt(getScanner().nextLine());

        System.out.println("Enter product's speed: ");
        this.speed = getScanner().nextLine();

        System.out.println("Enter product's producer: ");
        this.produder = getScanner().nextLine();
        //return this; => mutating funtion
    }

    @Override
    public void display() {
        System.out.println("Computer{" +
                "speed='" + speed + '\'' +
                ", produder='" + produder + '\'' +
                ", proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}');
    }


}
