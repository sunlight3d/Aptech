package com.library;

public class Textbook extends Book{
    protected String subject;
    public Textbook(String title, String author, int year, double price, String subject) {
        super(title, author, year, price);
        this.subject = subject;
    }

    @Override
    public void displayInfo() {
        System.out.printf("title: %s, author: %s, year: %d, price: %f", title, author,year,price);
        System.out.printf("genre: %s", subject);
    }
}
