package com.product.books;

import com.product.Product;

import static com.product.Helper.getScanner;

public class Book extends Product {
    private String type;
    private String publisher;

    {
        //initialization block, run before constructor
        type = "";
        publisher = "";
    }

    public Book() {
    }

    public Book(String proId, String proName, int year, float price,
                String type, String publisher) {
        super(proId, proName, year, price);
        this.type = type;
        this.publisher = publisher;
    }

    @Override
    public void input() {
        System.out.println("Enter bookId: ");
        this.proId = getScanner().nextLine();

        System.out.println("Enter book's name: ");
        this.proName = getScanner().nextLine();

        System.out.println("Enter book's year: ");
        this.year = Integer.parseInt(getScanner().nextLine());

        System.out.println("Enter book's type: ");
        this.type = getScanner().nextLine();

        System.out.println("Enter book's publisher: ");
        this.publisher = getScanner().nextLine();
    }

    @Override
    public void display() {
        System.out.println("Book{" +
                "type='" + type + '\'' +
                ", publisher='" + publisher + '\'' +
                ", proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}');
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
