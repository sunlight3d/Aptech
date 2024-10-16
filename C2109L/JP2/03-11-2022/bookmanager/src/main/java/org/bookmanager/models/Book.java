package org.bookmanager.models;

public class Book {
    private String code;
    private String bookName;
    private Float price;
    private int categoryId;

    public Book() {}

    public Book(String code, String bookName, Float price, int categoryId) {
        this.code = code;
        this.bookName = bookName;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
