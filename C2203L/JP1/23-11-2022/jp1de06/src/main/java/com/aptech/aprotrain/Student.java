package com.aptech.aprotrain;

import static com.aptech.aprotrain.Helper.*;

public class Student implements IStudent{
    private int id;
    private String fullName;
    private String email;
    private float mark;

    public Student() {}

    public Student(int id, String fullName, String email, float mark) {
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
        System.out.println("Enter id:");
        this.id = inputInt();

        System.out.println("Enter fullname: ");
        this.fullName = inputString();

        System.out.println("Enter email: ");
        this.email = inputString();

        System.out.println("Enter mark: ");
        this.mark = inputFloat();
    }

    @Override
    public void display() {
        System.out.println("Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", mark=" + mark +
                '}');
    }

}
