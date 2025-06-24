package com.aptech.bai03;

import java.io.InvalidObjectException;
import java.util.Scanner;

public class Student {
    private int id;//private, protected, public... => access modifier
    private String fullName;
    private Integer age;
    private double gpa;

    public Student(int id, String fullName, Integer age, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gpa = gpa;
    }
    public Student() {}

    public int getId() {
        return id;
    }

    public void setId(int id)  {
//        if(id < 0) {
//            throw new InvalidObjectException("id must be > 0");
//        }
        this.id = id;
    }

    public String getFullName() {
        //nguyen van a => Nguyen Van A
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
//        if(age < 0) {
//            throw new Exception("Age cannot be negative");
//        }
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void displayInfo() {
        System.out.println("Id: "+this.id);
        System.out.println("Fullname : "+this.getFullName());
        System.out.println("Age: "+this.age);
        System.out.println("GPA: "+this.gpa);
    }
    //factory method
    public static Student input(){
        System.out.println("Enter id:");
        int id = getScanner().nextInt();

        System.out.println("Enter fullname: ");
        String fullName = getScanner().next();

        System.out.println("Enter age: ");
        Integer age = getScanner().nextInt();

        System.out.println("Enter gpa: ");
        double gpa = getScanner().nextDouble();
        return new Student(id, fullName, age, gpa);
    }
    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
