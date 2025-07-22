package com.library;

public class Novel extends Book{
    protected String genre;
    public Novel(String title, String author, int year, double price, String genre) {
        super(title, author, year, price);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.printf("title: %s, author: %s, year: %d, price: %f", title, author,year,price);
        System.out.printf("genre: %s", genre);
    }
}
