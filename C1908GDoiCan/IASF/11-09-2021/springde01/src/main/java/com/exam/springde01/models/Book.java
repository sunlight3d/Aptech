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
}
