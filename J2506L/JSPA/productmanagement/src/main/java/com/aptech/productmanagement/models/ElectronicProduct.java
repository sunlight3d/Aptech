package com.aptech.productmanagement.models;

import java.util.Scanner;

public class ElectronicProduct extends Product{
    private int warrantyMonths;
    private String brand;
    @Override
    public double getFinalPrice() {
        return price * 1.1;
    }

    @Override
    public void input() {
        super.input();
        System.out.println("Enter warrantyMonths: ");
        int warrantyMonths = (new Scanner(System.in)).nextInt();

        System.out.println("Enter brand: ");
        String brand = (new Scanner(System.in)).next();
    }

    public ElectronicProduct() {}
    public ElectronicProduct(String id,
                             String name,
                             double price,
                             int warrantyMonths,
                             String brand
    ) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
        this.brand = brand;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
