DROP DATABASE SERVJSP_exam;
CREATE DATABASE SERVJSP_exam;
USE SERVJSP_exam;

CREATE TABLE Books(
	BookId int PRIMARY KEY AUTO_INCREMENT ,
	Title varchar(50) NULL,
	Price float NULL,
	CategoryId int NULL
 );

CREATE TABLE Category(
	CategoryId int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	CategoryName varchar(50) NULL
);

CREATE TABLE Users(
	UserId int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Username varchar(50) NULL,
	Password char(10) NULL
);
INSERT INTO Users(Username, Password) VALUES('hoangnd', '123456');

INSERT INTO Category(CategoryName) VALUES
('Nhat ky'),
('Tan Van'),
('Du lich');
INSERT INTO Books(Title, Price, CategoryId) VALUES('Mai mai tuoi 20', 123, 1);
INSERT INTO Books(Title, Price, CategoryId) VALUES('on ai hat ve Ha noi', 454, 2);
INSERT INTO Books(Title, Price, CategoryId) VALUES('Mai mai tuoi 20', 222, 3);

