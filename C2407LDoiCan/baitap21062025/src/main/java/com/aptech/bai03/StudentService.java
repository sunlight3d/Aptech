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
    public void showAllStudents() {
        for(Student student: students) {
            student.displayInfo();
        }
    }
    public void showMaxGpaStudent() {
        double maxGPA = Double.MIN_VALUE;
        Student studentWithMaxGpa = null;
        for(Student student: students) {
            maxGPA = student.getGpa() > maxGPA ? student.getGpa() : maxGPA;
            studentWithMaxGpa = student.getGpa() == maxGPA ? student:studentWithMaxGpa;
        }
        if(studentWithMaxGpa != null) {
            System.out.println("Student with max gpa: ");
            studentWithMaxGpa.displayInfo();
        }
    }
    public void filterStudents() {
        System.out.println("Enter gpa to filter: ");
        double desiredGPA = (new Scanner(System.in)).nextDouble();
        ArrayList<Student> filteredStudents = new ArrayList<>();
        for(Student student: students) {
            if(student.getGpa() >= desiredGPA) {
                filteredStudents.add(student);
                student.displayInfo();
            }
        }
    }
    public void sortStudents() {
        for(int i = 0; i < students.size(); i++) {
            for(int j = i + 1; j < students.size(); j++) {
                Student studentA = students.get(i);
                Student studentB = students.get(j);
                if(studentA.getGpa() < studentB.getGpa()) {
                    Student studentX = studentA;
                    studentA = studentB;
                    studentB = studentX;
                }
            }
        }
        showAllStudents();
    }
}
