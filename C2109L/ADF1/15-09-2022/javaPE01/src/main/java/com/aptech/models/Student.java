package com.aptech.models;

import java.util.Scanner;

public class Student{
    private String studentNumber;
    private String studentName;
    private String studentAddress;
    private int studentAge;

    public Student() {

    }
    public Student(String studentNumber, String studentName,
                   String studentAddress, int studentAge) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentAge = studentAge;
    }

    @Override
    public String toString() {
        return "studentNumber: "+this.studentNumber+"\n"+
                "studentName: "+this.studentName+"\n"+
                "studentAddress: "+this.studentAddress+"\n"+
                "studentAge: "+this.studentAge;
    }
}
