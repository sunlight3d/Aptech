package com.aptech.de01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class De01Application {
	public static void main(String[] args) {
		SpringApplication.run(De01Application.class, args);
	}
}
/*
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL
);
INSERT INTO users (username, password)
VALUES ('john', 'password1');

INSERT INTO users (username, password)
VALUES ('jane', 'password2');

CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  category VARCHAR(50) NOT NULL,
  price DOUBLE NOT NULL
);

INSERT INTO books (title, category, price)
VALUES
  ('The Alchemist', 'Fiction', 12.99),
  ('Sapiens: A Brief History of Humankind', 'Non-fiction', 19.99),
  ('The Hitchhiker\'s Guide to the Galaxy', 'Science Fiction', 14.50),
  ('Gone Girl', 'Thriller', 9.99),
  ('Pride and Prejudice', 'Romance', 8.99),
  ('Harry Potter and the Sorcerer\'s Stone', 'Fantasy', 17.99),
  ('The Da Vinci Code', 'Mystery', 11.99),
  ('Steve Jobs', 'Biography', 13.50),
  ('The Art of War', 'History', 16.99),
  ('Atomic Habits', 'Self-help', 10.99);

* */