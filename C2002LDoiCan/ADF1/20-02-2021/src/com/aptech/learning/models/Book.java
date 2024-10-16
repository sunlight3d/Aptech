package com.aptech.learning.models;

public class Book {
    private String name;
    //nho den "foreign key"
    private Author author;
    private double price;
    private int quantity;
    //overload = cung ten ham, khac input parameters
    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public Book(String name, Author author, double price, int quantity) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }
    //vd khac ve overload ?
    //getter, setter ? auto-generate

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        //ternary
        String authorString = author == null ? "" : ", " + author.toString();
        return "Book[" +
                "name='" + name + '\'' +
                authorString +
                ", Price=" + price +
                ", Quantity=" + quantity +
                '}';
    }
}
