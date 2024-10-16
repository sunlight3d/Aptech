package com.aptech.data.impl;

import com.aptech.data.IDocument;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Book implements IDocument {
    private int     id;
    private String  bookName;
    private String  authorName;
    private float   price;

    public Book() {

    }
    public Book(int id, String bookName, String authorName, float price) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void input() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            System.out.println("Enter id: ");
            this.id = Integer.valueOf(bufferedReader.readLine());

            System.out.println("Enter bookName: ");
            this.bookName = bufferedReader.readLine();

            System.out.println("Enter authorName: ");
            this.authorName = bufferedReader.readLine();

            System.out.println("Enter price: ");
            this.price = Float.valueOf(bufferedReader.readLine());
        }catch (IOException e) {
            System.err.println("Cannot input, error: "+e.getMessage());
        }


    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +"\n"+
                ", bookName='" + bookName +"\n"+
                ", authorName='" + authorName +"\n"+
                ", price=" + price;

    }
}
