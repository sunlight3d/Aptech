package aptech.data.impl;

import aptech.data.IDocument;

import java.util.Scanner;
public class Book implements IDocument {
    //1 class can implement > 1 interface
    private Integer id;
    private String  bookName;
    private String  authorName;
    private Float   price;

    public Book() {

    }

    public Book(int     id,
                String  bookName,
                String  authorName,
                float   price) {
        this.id         = id;
        this.bookName   = bookName;
        this.authorName = authorName;
        this.price      = price;
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
        System.out.println("Input id = ");
        this.id = (new Scanner(System.in)).nextInt();

        System.out.println("Nhap ten sach: ");
        this.bookName = (new Scanner(System.in)).next();

        System.out.println("Ten tac gia: ");
        this.authorName = (new Scanner(System.in)).next();

        System.out.println("Enter book's price ?");
        this.price = (new Scanner(System.in)).nextFloat();
    }

    @Override
    public void show() {
        System.out.println(
            "id: "          +this.id+ "\n"+
            "bookName: "    +this.bookName+ "\n"+
            "authorName: "  +this.authorName+ "\n"+
            "price"         +this.price+"\n");
    }
}
