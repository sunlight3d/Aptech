package com.myapp.aptech;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StudentTest {
    private static String fileName = "students.dat";
    private static int NUMBER_OF_STUDENTS = 3;
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        try {
            for(int i = 0; i < NUMBER_OF_STUDENTS; i++) {
                System.out.println("Enter student "+(i+1));
                Student student = new Student();
                student.input();
                students.add(student);
            }

            FileWriter fileWriter = new FileWriter(fileName);
            for (Student student: students) {
                fileWriter.write(String.format(
                        "%s, %s, %s, %d\n",
                        student.getRollNumber(),
                        student.getName(),
                        student.getAddress(),
                        student.getAge()));
            }
            fileWriter.close();
            students.clear();
            System.out.println("Read from file");
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            if(file.exists()) {
                while (true) {
                    String eachLine = bufferedReader.readLine();
                    if(eachLine == null) {
                        break;
                    }
                    //convert line to object
                    String[] lineArray = eachLine.split(",");
                    String rollNumber = lineArray[0].trim();
                    String name = lineArray[1].trim();
                    String address = lineArray[2].trim();
                    Integer age = Integer.valueOf(lineArray[3].trim());
                    Student student = new Student(
                            rollNumber,
                            name,
                            address,
                            age
                    );
                    students.add(student);
                }
                System.out.println("output students:");
                students.stream()
                        .filter((Student student) -> student.getAge() < 18)
                        .forEach((Student student) ->{
                            System.out.println(student);
                });
            }else {
                System.err.println("Cannot find file to read");
            }
        }catch (Exception e) {
            System.err.println("Error creating object : "+e.getMessage());
        }
    }
}
