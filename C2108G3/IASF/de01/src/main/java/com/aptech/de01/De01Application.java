package com.aptech.de01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class De01Application {
	//JohnDoe   | secret123
	public static void main(String[] args) {
		SpringApplication.run(De01Application.class, args);
	}

}

/*
CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255)
);
INSERT INTO users (username, password)
VALUES ('JohnDoe', 'secret123'),
       ('JaneSmith', 'password456');

CREATE TABLE books (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255),
  category VARCHAR(100),
  price double
);

INSERT INTO books (title, category, price)
VALUES ('The Great Gatsby', 'Fiction', 19.99),
       ('To Kill a Mockingbird', 'Fiction', 14.99),
       ('1984', 'Science Fiction', 12.99),
       ('Pride and Prejudice', 'Romance', 9.99);

* */
