package com.aptech.system;

import com.aptech.aprotrain.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();
    private static int NUMBER_OF_STUDENTS = 3;
    public void addStudent() {
        students.clear();
        for(int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            System.out.println(String.format("Enter information of student: %d", i+1));
            Student student = new Student();
            student.input();
            students.add(student);
        }
    }
    public void showStudent() {
        students.forEach((Student student) -> {
            student.display();
        });
    }
    public ArrayList<Student> sortStudentByMark() {
        return new ArrayList<>(this.students
                .stream()
                .sorted((Student student1, Student student2)
                        -> (int)(student1.getMark() - student2.getMark()))
                .toList());
    }

}
