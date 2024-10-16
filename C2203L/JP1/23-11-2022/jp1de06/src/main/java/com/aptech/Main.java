package com.aptech;

import com.aptech.aprotrain.Helper.*;
import com.aptech.aprotrain.Student;
import com.aptech.system.StudentManagement;

import java.util.function.Consumer;

import static com.aptech.aprotrain.Helper.*;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        StudentManagement studentManagement = new StudentManagement();
        while (choice != 4) {
            System.out.println("1.Add New.");
            System.out.println("2.Show All.");
            System.out.println("3.Sort.");
            System.out.println("4.Exit.");
            System.out.println("Your choice: ");
            choice = inputInt();
            switch (choice) {
                case 1:
                    studentManagement.addStudent();
                    break;
                case 2:
                    studentManagement.showStudent();
                    break;
                case 3:
                    studentManagement
                            .sortStudentByMark()
                            .forEach((Student student) -> {
                                student.display();
                    });
                    break;
                case 4:
                    break;
                    default:
                    System.err.println("Please select 1-4");
                    break;
            }
        }
    }
}
