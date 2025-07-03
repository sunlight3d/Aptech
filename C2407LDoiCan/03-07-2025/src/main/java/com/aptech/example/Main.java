package com.aptech.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Jenny", "c234", 8.8f));
        students.add(new Student("John", "x254", 8.6f));
        students.add(new Student("Ann", "z123", 4.6f));
        students.add(new Student("Peter", "w223", 5.6f));
        /*
        for(Student student: students) {
            System.out.println(student);
        }
         */
        /*
        students.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });
         */
        /*
        students.forEach((Student student) -> {
            System.out.println(student);
        });

         */
        students.forEach(System.out::println);
        //show all students with gpa > 5?
        List<Student> filteredStudents = new ArrayList<>();
        for(Student student: students) {
            if(student.getGpa() > 6) {
                filteredStudents.add(student);
            }
        }
        System.out.println("Filtered students: ");
        filteredStudents.forEach(System.out::println);
    }
}