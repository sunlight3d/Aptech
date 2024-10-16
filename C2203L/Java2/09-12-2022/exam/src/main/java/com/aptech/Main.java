package com.aptech;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. View all Exams");
            System.out.println("2. Add new exam");
            System.out.println("3. Remove exam");
            System.out.println("4. Exit");
            int choice = (new Scanner(System.in)).nextInt();
        }
    }
}
/*
CREATE DATABASE exam;
USE exam;
CREATE TABLE tbl_exam(
    id INT PRIMARY KEY AUTO_INCREMENT,
    exam_name VARCHAR(50),
    exam_date DATE,
    exam_duration INT,
    exam_room VARCHAR(10)
);
* */