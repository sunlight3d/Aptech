package com.project.book.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name ="books")
@RequiredArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long bookID;
    private String title;
    private float price;
    private Long categoryID;
//    public Book( String title, Long categoryID, float price) {
//        this.title = title;
//        this.categoryID = categoryID;
//        this.price = price;
//    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", categoryID='" + categoryID + '\'' +
                '}';
    }
}
