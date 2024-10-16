package com.product.books;

import com.product.Product;

import java.util.Scanner;

public class Book extends Product {
    private String type;
    private String publisher;

    public Book() {
    }

    public Book(String productId, String productName, int year, float price,
                String type, String publisher) {
        super(productId, productName, year, price);
        this.type = type;
        this.publisher = publisher;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book's type: ");
        this.price = scanner.nextFloat();
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Book{" +
                "type='" + type + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
