CREATE DATABASE IF NOT EXIST EXAM;

USE EXAM;

CREATE TABLE Department(
    id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Employee(
    id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    dept_id int,
    age int CHECK (age >= 18 && age < 80),
    sex VARCHAR(6)
);

INSERT INTO Department (name) VALUES
('HR'),
('Sales'),
('IT'),
('Marketing');

INSERT INTO Employee (name, dept_id, age, sex) VALUES
('John Doe', 1, 25, 'Male'),
('Jane Smith', 2, 30, 'Female'),
('Alice Johnson', 3, 28, 'Female'),
('Bob Brown', 4, 45, 'Male'),
('Mike Davis', 1, 22, 'Male'),
('Carol White', 2, 35, 'Female'),
('Eve Black', 3, 40, 'Female'),
('Sam Blue', 4, 50, 'Male');



