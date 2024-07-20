CREATE DATABASE IF NOT EXISTS exam;
--create table first, then create contraints
USE exam;
CREATE TABLE Department(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Employee(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    dept_id INT,
    age INT CHECK(age > 18 && age < 80),
    sex VARCHAR(6)
);  

ALTER TABLE Employee
ADD ADD CONSTRAINT FK_EmployeeDepartment
FOREIGN KEY (dept_id) REFERENCES Department(id);