package com.student.manangement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentTest {
    private List<Student> students = new ArrayList<>();
    private String fileName = "student.bat";
    private static int NUMBER_OF_STUDENTS = 3;
    public void input() throws Exception{
        for(int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            System.out.println("Enter information of student "+(i+1));
            Student student = new Student();
            student.input();
            students.add(student);
        }
    }
    public void writeToFile(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream
                                                (new FileOutputStream(fileName));
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void readFromFile() {
        try {
            students.clear();
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));

            //students = (ArrayList<Student>)objectInputStream.readObject();
            for(Student student: (ArrayList<Student>)objectInputStream.readObject()) {
                students.add(student);
            }
            System.out.println("The Object has been read from the file");
            objectInputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void filterStudents(){
        List<Student> filteredStudents = this.students.stream()
                .filter((Student student) -> student.getAge() < 18)
                .toList();
        for (Student student: filteredStudents) {
            System.out.println(student);
        }
    }
}
