package com.example.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
http://localhost:8089/project01-war/CalculatorServlet
CREATE DATABASE c2209GDoiCan;
USE c2209GDoiCan;

CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    email VARCHAR(100)
);

INSERT INTO student (name, age, email) VALUES 
('John Doe', 20, 'john.doe@example.com'),
('Jane Smith', 22, 'jane.smith@example.com'),
('Alice Johnson', 19, 'alice.johnson@example.com'),
('Bob Brown', 21, 'bob.brown@example.com'),
('Charlie Davis', 23, 'charlie.davis@example.com'),
('Emily Clark', 20, 'emily.clark@example.com'),
('David Williams', 24, 'david.williams@example.com'),
('Sophia Lee', 18, 'sophia.lee@example.com'),
('Michael Taylor', 22, 'michael.taylor@example.com'),
('Sarah Miller', 19, 'sarah.miller@example.com');

 */
@Stateless
//@LocalBean
public class CalculatorBean implements CalculatorBeanLocal {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
