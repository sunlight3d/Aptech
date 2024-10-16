package com.aptech.aprotrain;

import java.util.Scanner;

public class Student implements IStudent{
    private int id;
    private String fullName;
    private String email;
    private float mark;
    Student(){
    }

    public Student(int id, String fullName,
                   String email, float mark) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public void input() {
        System.out.println("Enter id: ");
        this.id = Helper.getScanner().nextInt();

        System.out.println("Enter fullName: ");
        this.fullName = Helper.getScanner().next();

        System.out.println("Enter email: ");
        this.email = Helper.getScanner().next();

        System.out.println("Enter mark: ");
        this.mark = Helper.getScanner().nextFloat();
    }

    @Override
    public void display() {
        /*
        System.out.println(
                "id: "+id
                + "fullName: "+fullName
                + "email: "+email
                + "mark: "+mark
        );
        */
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "id: "+id
                + ", fullName: "+fullName
                + ", email: "+email
                + ", mark: "+mark;
    }
}
