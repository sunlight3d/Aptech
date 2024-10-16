package com.aptech.de12.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "books")  // Đặt tên bảng là "products"
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    @Column(precision = 10, scale = 2)  // Định dạng trường price với kiểu Decimal(10,2)
    private BigDecimal price;
}

/*
INSERT INTO books (title, author, price) VALUES
('To Kill a Mockingbird', 'Harper Lee', 19.99),
('1984', 'George Orwell', 15.99),
('The Great Gatsby', 'F. Scott Fitzgerald', 10.50),
('Moby Dick', 'Herman Melville', 25.45),
('War and Peace', 'Leo Tolstoy', 30.00),
('Pride and Prejudice', 'Jane Austen', 12.75),
('The Catcher in the Rye', 'J.D. Salinger', 22.99),
('The Hobbit', 'J.R.R. Tolkien', 18.50),
('Crime and Punishment', 'Fyodor Dostoevsky', 20.00),
('The Odyssey', 'Homer', 14.95);

* */