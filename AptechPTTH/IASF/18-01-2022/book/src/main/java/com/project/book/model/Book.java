package com.project.book.model;

import javax.persistence.*;

@Entity
@Table(name ="books")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String bookID;
    private String title;
    private float price;
    private String categoryID;

    public Book() {
    }

    public Book(String bookID, String title, float price, String categoryID) {
        this.bookID = bookID;
        this.title = title;
        this.price = price;
        this.categoryID = categoryID;
    }
    public Book( String title, String categoryID, float price) {
        this.title = title;
        this.categoryID = categoryID;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", categoryID='" + categoryID + '\'' +
                '}';
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }
}
