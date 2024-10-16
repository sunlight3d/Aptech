package com.student.manangement;

import java.io.Serializable;
import java.util.regex.Pattern;

import static com.student.manangement.Helper.*;

public class Student implements Serializable {
    private String rollNumber = "";
    private String name = "";
    private String address = "";
    private int age;

    public Student() {

    }
    public Student(String rollNumber, String name, String address, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public void input() throws Exception{
        try {
            //validate here
            //^[a-zA-Z]{1}[0-9]{4}[a-zA-Z]{1,2}[0-9]{4}$
            while(!Pattern.compile("^[a-zA-Z]{1}[0-9]{4}[a-zA-Z]{1,2}[0-9]{4}$")
                    .matcher(this.rollNumber).matches()) {
                this.rollNumber = inputString("Enter rollnumber");
            };
            this.name = inputString("Enter name");
            this.address = inputString("Enter address");
            this.age = inputInt("Enter age");
        }catch (Exception e) {
            throw new Exception("Cannot input student's information"+e.getMessage());
        }
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}