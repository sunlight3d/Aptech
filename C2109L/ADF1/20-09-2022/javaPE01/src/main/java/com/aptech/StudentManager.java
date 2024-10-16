package com.aptech;

import com.aptech.models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private final int NUMBER_OF_STUDENTS = 2;
    private ArrayList<Student> students = new ArrayList<>();
    public void inputStudents() {
        for(int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            System.out.println(String.format("Enter info of student: %d", i+1));
            System.out.println("Enter student number: ");
            String studentNumber = (new Scanner(System.in)).next();

            System.out.println("Enter student name: ");
            String studentName = (new Scanner(System.in)).next();

            System.out.println("Enter student address: ");
            String studentAddress = (new Scanner(System.in)).next();

            System.out.println("Enter student age: ");
            int studentAge = (new Scanner(System.in)).nextInt();
            Student student = new Student(studentNumber, studentName,
                    studentAddress, studentAge);
            //student is "local variable"
            this.students.add(student);
        }
        System.out.println("haha");
    }
    public void showAllStudents() {
        for(int i = 0; i < this.students.size(); i++) {
            Student student = this.students.get(i);
            System.out.println(student.toString());
        }
    }
}
