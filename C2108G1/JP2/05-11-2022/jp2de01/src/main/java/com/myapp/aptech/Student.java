package com.myapp.aptech;

import javax.management.InvalidAttributeValueException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Student {
    private String  rollNumber;
    private String  name;
    private String  address;
    private int     age;

    public Student(String rollNumber, String name, String address, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Student() {

    }
    public void input() throws  Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            System.out.println("Enter rollNumber: ");
            String rollNumber = bufferedReader.readLine();
            boolean isValidRollNumber = Pattern.compile("^[a-zA-Z]{1}[0-9]{4}[a-zA-Z]{1,2}[0-9]{4}$",
                            Pattern.CASE_INSENSITIVE)
                    .matcher(rollNumber).find();
            if(!isValidRollNumber) {
                System.err.println("Invalid rollnumber, please input again");
            }else {
                this.rollNumber = rollNumber;
                break;
            }
        }
//        if(!isValidRollNumber) {
//            throw new InvalidAttributeValueException("Invalid roll number");
//        }

        System.out.println("Enter name: ");
        this.name = bufferedReader.readLine();

        System.out.println("Enter address: ");
        this.address = bufferedReader.readLine();

        System.out.println("Enter age: ");
        this.age = Integer.valueOf(bufferedReader.readLine());
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
