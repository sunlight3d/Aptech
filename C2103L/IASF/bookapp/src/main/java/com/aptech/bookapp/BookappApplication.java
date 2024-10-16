package com.aptech.bookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookappApplication.class, args);
	}

}

/*
USE C2103L;
CREATE TABLE books(
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL DEFAULT '',
	category VARCHAR(50) NOT NULL,
	price FLOAT CHECK(price >= 0)
);
CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	date_of_birth DATETIME
);

INSERT INTO books (title, category, price) VALUES
('Sách 1', 'Học Tập', 20000),
('Sách 2', 'Tiểu Thuyết', 30000),
('Sách 3', 'Khoa Học', 40000),
('Sách 4', 'Nghệ Thuật', 50000),
('Sách 5', 'Văn Học', 60000),
('Sách 6', 'Lịch Sử', 70000),
('Sách 7', 'Toán Học', 80000),
('Sách 8', 'Thiên Văn', 90000),
('Sách 9', 'Địa Lý', 100000),
('Sách 10', 'Tâm Lý', 110000);

* */