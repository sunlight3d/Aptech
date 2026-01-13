package com.aptech.productmanagement.models;

import java.util.Scanner;

public class FoodProduct extends Product {
    protected String expiryDate;//mm-dd-YYYY
    protected double weight;
    @Override
    public double getFinalPrice() {
        return getPrice() * weight;
    }
    @Override
    public void input() {
        super.input();
        System.out.println("Enter expiryDate(mm-dd-YYYY):");
        String expiryDate = (new Scanner(System.in)).next();
        
        System.out.println("Enter brand: ");
        String brand = (new Scanner(System.in)).next();
    }
    public FoodProduct() {}
    public FoodProduct(String id,
                       String name,
                       double price,
                       String expiryDate,
                       double weight
    ) {
        super(id, name, price);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
