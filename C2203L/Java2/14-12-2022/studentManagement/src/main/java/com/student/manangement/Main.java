package com.student.manangement;

public class Main {
    public static void main(String[] args) {
        try {
            StudentTest studentTest = new StudentTest();
            studentTest.input();
            studentTest.writeToFile();
            studentTest.readFromFile();
            studentTest.filterStudents();
        } catch (Exception e) {
            System.err.println("Error is: "+e.getMessage());
        }
    }
}