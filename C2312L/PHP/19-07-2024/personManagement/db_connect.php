<?php
/*
how to connect from PHP to mysql db(use: root, pass: "", db's name: c2312l, server: localhost, 3306)
using pdo
write a function to do this inside php file
 */
//define("SERVER_NAME", "localhost");
const SERVER_NAME = "localhost";
const USERNAME = "root";
const PASSWORD = "";
const DATABASE_NAME = "c2312L";
const PORT = 3306;
/**
CREATE TABLE tblPerson(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100), 
    Gender bit, 
    DateOfBirth DATE
);

INSERT INTO tblPerson (Name, Gender, DateOfBirth) VALUES 
('Nguyen Van A', 1, '1990-01-01'),
('Tran Thi B', 0, '1992-02-15'),
('Le Van C', 1, '1988-03-30'),
('Hoang Anh D', 1, '1995-04-21'),
('Nguyen Thu E', 0, '1993-05-25'),
('Pham Tuan F', 1, '1996-06-15'),
('Vu Mai G', 0, '1991-07-10'),
('Truong Minh H', 1, '1989-08-05'),
('Do Bao I', 1, '1987-09-09'),
('Bui Tuyet J', 0, '1985-10-16'),
('Le Khoi K', 1, '1984-11-11'),
('Phan Lan L', 0, '1994-12-20'),
('Mai Trong M', 1, '1992-01-14'),
('Ho Van N', 1, '1990-02-18'),
('Dang Phuong O', 0, '1988-03-22'),
('Tran Quy P', 1, '1986-04-27'),
('Nguyen Ha Q', 0, '1983-05-31'),
('Le Giang R', 1, '1997-06-30'),
('Pham Bao S', 1, '1991-07-29'),
('Vu Thanh T', 0, '1985-08-15'),
('Bui Uyen U', 0, '1993-09-12'),
('Doan Vien V', 1, '1989-10-28'),
('Le Xuan W', 1, '1995-11-21');


 */

function getPDO()
{
    try {
        $connection_string = "mysql:host=" . SERVER_NAME
            . ";port=" . PORT
            . ";dbname=" . DATABASE_NAME
            . ";charset=utf8";
        $pdo = new PDO($connection_string, USERNAME, PASSWORD);
        // Set the PDO error mode to exception
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $pdo;
    } catch (PDOException $e) {
        die("Connection failed: " . $e->getMessage());
    }
}

// Example of using the function
