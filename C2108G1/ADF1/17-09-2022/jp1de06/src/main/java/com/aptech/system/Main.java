package com.aptech.system;

import com.aptech.aprotrain.IStudent;
import com.aptech.aprotrain.Student;
import com.aptech.aprotrain.StudentManagement;

public class Main {
    public static void main(String[] args) {
        //IStudent xx = new IStudent();//cannot initialize an object from Interface
        //But you can init an anonymous object which implements the interface
        IStudent xx1 = new IStudent() {
            @Override
            public void input() {
                System.out.println("you press input");
            }

            @Override
            public void display() {
                System.out.println("you press display");
            }
        };
        xx1.input();
        xx1.display();
        //xx1.display();
        //Student studentX = new Student(1, "aaaa","ds@fff.com", 10f);
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.showMenu();

    }
}