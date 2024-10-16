package com.product.books;

import com.product.Product;

import java.util.Scanner;

public class Book extends Product {
    private String type;
    private String publisher;

    public Book() {
    }
    public Book(String prodId, String prodName, int year, float price,
                String type, String publisher) {
        super(prodId, prodName, year, price);
        this.type = type;
        this.publisher = publisher;
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

        System.out.println("Enter type : ");
        this.type = (new Scanner(System.in)).next();

        System.out.println("Enter publisher : ");
        this.publisher = (new Scanner(System.in)).next();
    }

    @Override
    public void display() {
        System.out.println(
                "id: "+this.prodId+
                        "name: "+this.prodName+
                        "id: "+this.year+
                        "id: "+this.price+
                        "id: "+this.type+
                        "id: "+this.publisher);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
