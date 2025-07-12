package com.aptech.myapp;

import java.util.Scanner;

public class Book extends Object{
    private int id;
    private String title;
    private String author;
    private double price;

    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    private Scanner getScanner() {
        return new Scanner(System.in);
    }
    public void input() {
        try {
            System.out.println("Enter id: ");
            this.id = getScanner().nextInt();

            System.out.println("Enter title: ");
            this.title = getScanner().nextLine();

            System.out.println("Enter author: ");
            this.author = getScanner().nextLine();

            System.out.println("Enter price: ");
            this.price = getScanner().nextDouble();
        }
        catch (Exception e) {
            System.err.println("Error input data: "+e.getMessage());
        }
    }
    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + 
                ", title=" + title + 
                ", author=" + author + 
                ", price=" + price + 
                '}';
    }    
}
