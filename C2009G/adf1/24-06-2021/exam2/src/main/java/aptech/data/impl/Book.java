package aptech.data.impl;

import aptech.data.IDocument;

import java.util.Scanner;

public class Book implements IDocument {
    //property/field
    private int id;
    private String bookName;
    private String authorName;
    private float price;
    public Book() {
        this.id = 0;
        this.bookName = "";
        this.authorName = "";
        this.price = 0.0f;
    }
    public Book(int id, String bookName,
                String authorName, float price) {
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
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter book's id : ");
            this.id = scanner.nextInt();

            System.out.println("Enter book's name : ");
            this.bookName = scanner.next();

            System.out.println("Enter author's name : ");
            this.authorName = scanner.next();

            System.out.println("Enter book's price : ");
            this.price = scanner.nextFloat();
        }catch (Exception exception) {
            System.err.println("Cannot input Book, error = "+exception.toString());
        }
    }

    @Override
    public void show() {
        System.out.println(String.format("Book'id = %d, book's name: %s, author's name : %s, price: %.2f",
           this.id, this.bookName, this.authorName, this.price
        ));
    }
}
