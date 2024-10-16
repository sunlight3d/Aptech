package com.aptech.aprotrain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();
    public void addStudent(){
        System.out.println("addStudent");
        for(int i = 0; i<3; i++) {
            Student student = new Student();
            student.input();
            boolean isExistingStudentName = (students
                    .stream()
                    .filter(eachStudent -> eachStudent.getFullName()
                            .equals(student.getFullName())).toList()).size() > 0;
            if(!isExistingStudentName) {
                this.students.add(student);
            }

        }
    }
    public void showStudent(){
        System.out.println("showStudent");
        students.forEach((Student student)-> {
            student.display();
        });
    }
    public void sortStudentByMark(){
        System.out.println("sortStudentByMark");
        this.students.sort((Student student1, Student student2) -> {
            return (int)(student2.getMark() - student1.getMark());
        });
//        students.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return (int)(student1.getMark() - student2.getMark());
//            }
//        });
    }
//    private Scanner getScanner() {
//        return new Scanner(System.in);
//    }
    public void showMenu() {
        int choice = 0;
        //fake data
        students.add(new Student(1, "x1", "x1@gmail.com", 8f));
        students.add(new Student(2, "x2", "x2@gmail.com", 5f));
        students.add(new Student(3, "x3", "x3@gmail.com", 7f));

        while(choice != 4) {
            System.out.println("=== MENU ===\n" +
                    "1.Add New.\n" +
                    "2.Show All.\n" +
                    "3.Sort.\n" +
                    "4.Exit.\n" +
                    "Your choice: \n");
            choice = Helper.getScanner().nextInt();
            switch (choice) {
                case 1: {
                    this.addStudent();
                }
                    break;
                case 2: {
                    this.showStudent();
                }
                    break;
                case 3: {
                    this.sortStudentByMark();
                }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("You must choose 1,2,3,4");
            }
        }
        System.out.println("Program end");
    }

}
