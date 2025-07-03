package com.aptech.example;

public class Student extends Person{
    private String code;
    private float gpa;

    public Student(String name, String code, float gpa) {
        super(name);
        this.code = code;
        this.gpa = gpa;
    }

    public Student(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("name: %s, code: %s, gpa: %f", super.getName(), this.code, this.gpa);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}
