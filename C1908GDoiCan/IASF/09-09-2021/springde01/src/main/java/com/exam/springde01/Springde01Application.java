package com.exam.springde01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
docker run -d --rm --name mysql-spring-boot-tutorial -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_USER=hoangnd -e MYSQL_PASSWORD=123456 -e MYSQL_DATABASE=test_db -p 3309:3306 --volume mysql-spring-boot-tutorial-volume:/var/lib/mysql mysql:latest

mysql -h localhost -P 3309 --protocol=tcp -u hoangnd -p

CREATE TABLE Books (
	bookId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	title NVARCHAR(100),
	price FLOAT DEFAULT 0,
	categoryId INT
);
CREATE TABLE Category (
	categoryId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	categoryName NVARCHAR(100)
);
CREATE TABLE Users(
		userId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
		username NVARCHAR(50),
		password NVARCHAR(50)
);
ALTER TABLE Books
ADD CONSTRAINT FK_CategoryBook
FOREIGN KEY (categoryId) REFERENCES Category(categoryId);
*/
@SpringBootApplication
public class Springde01Application {

	public static void main(String[] args) {
		SpringApplication.run(Springde01Application.class, args);
	}

}
