package com.aptech.ex001.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "products")  // Đặt tên bảng là "products"
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name must be less than 255 characters")
    private String name;

    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    @Column(precision = 10, scale = 2)  // Định dạng trường price với kiểu Decimal(10,2)
    private BigDecimal price;
}
/*
INSERT INTO products (name, price) VALUES
('Apple iPhone 13', 799.99),
('Samsung Galaxy S21', 699.99),
('Google Pixel 6', 599.99),
('Sony WH-1000XM4 Headphones', 349.99),
('Dell XPS 13 Laptop', 999.99),
('Apple MacBook Air', 1099.99),
('Microsoft Surface Pro 7', 899.99),
('Bose QuietComfort 35 II', 299.99),
('Amazon Echo Dot', 49.99),
('Sony PlayStation 5', 499.99),
('Nintendo Switch', 299.99),
('Apple AirPods Pro', 249.99),
('Google Nest Hub', 89.99),
('Fitbit Charge 5', 179.99),
('Roku Streaming Stick+', 49.99),
('Samsung Galaxy Watch 4', 279.99),
('Logitech MX Master 3', 99.99),
('Canon EOS R5', 3899.99),
('Nikon Z6', 1999.99),
('DJI Mavic Air 2', 799.99),
('GoPro HERO9 Black', 399.99),
('Xbox Series X', 499.99),
('HP Spectre x360', 1299.99);


* */