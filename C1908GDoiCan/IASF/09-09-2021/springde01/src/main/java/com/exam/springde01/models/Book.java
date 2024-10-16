package com.exam.springde01.models;
import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    private Long bookId;
    private String title;
    @Min(value=0)
    private Float price;
    private Long categoryId;
    public Book() {}

    public Book(String title, Float price, Long categoryId) {
        this.title = title;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
