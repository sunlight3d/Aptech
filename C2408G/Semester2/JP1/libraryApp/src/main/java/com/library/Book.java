package com.library;

public abstract class Book {
    protected String title;
    protected String author;
    protected int year;
    protected double price;
    //all arguments constructor

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }
    public abstract void displayInfo();
    public double getPrice() {
        return  price;
    }
}
