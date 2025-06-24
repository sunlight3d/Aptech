package com.aptech.bai03;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    /*
    public void addStudent() {
        Student student = new Student();
        System.out.println("Enter id:");
        int id = getScanner().nextInt();
        student.setId(id);

        System.out.println("Enter fullname: ");
        String fullName = getScanner().next();
        student.setFullName(fullName);

        System.out.println("Enter age: ");
        Integer age = getScanner().nextInt();
        student.setAge(age);

        System.out.println("Enter gpa: ");
        double gpa = getScanner().nextDouble();
        student.setGpa(gpa);
        students.add(student);
    }
 */
    /*
    public void addStudent() {
        System.out.println("Enter id:");
        int id = getScanner().nextInt();

        System.out.println("Enter fullname: ");
        String fullName = getScanner().next();

        System.out.println("Enter age: ");
        Integer age = getScanner().nextInt();

        System.out.println("Enter gpa: ");
        double gpa = getScanner().nextDouble();
        Student student = new Student(id, fullName, age, gpa);
        students.add(student);
    }
     */
    public void addStudent() {
        students.add(Student.input());
    }
}
