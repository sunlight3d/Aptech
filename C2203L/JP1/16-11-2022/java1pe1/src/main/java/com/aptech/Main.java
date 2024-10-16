package com.aptech;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Main {
    public static void main(String[] args) {
        String s = "Welcome to Aptech";
        TreeMap c = null;
        //String s = "          Junit working         finen jiuwew                    jijij            jeje";
        Question01 question01 = new Question01();
        System.out.println("count = " + question01.countWord(s));
        //bai 2
        ArrayList<Student> students = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            Student student = new Student();
            student.input();
            students.add(student);
        }

        //String studentNumber, String studentName, String studentAddress, int studentAge
//        students.add(new Student("11", "s1", "a1", 19));
//        students.add(new Student("11", "s1", "a1", 23));
//        students.add(new Student("11", "s1", "a1", 18));
//        students.add(new Student("11", "s1", "a1", 90));
//        students.add(new Student("11", "s1", "a1", 15));

        students.forEach((Student student)->{
            System.out.println(student);
        });
        int maxAge = students.stream()
                .mapToInt((Student student) -> student.getStudentAge())
                .max().getAsInt();
        System.out.println("Oldest student:");
        students.stream()
                .filter((Student student) -> student.getStudentAge() == maxAge)
                .toList()
                .forEach((Student student)->{
                    System.out.println(student);
                });
        System.out.println("Question 2");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter added toppings: ");
            String addedToppings = in.readLine();
            System.out.print("Enter diameter: ");
            double diamter = Double.parseDouble(in.readLine());
            System.out.print("Enter number of slices: ");
            int slices = Integer.parseInt(in.readLine());
            System.out.println("OUTPUT:");
            Pizza p = new Pizza(diamter, slices);
            System.out.println(p);
            p = new DeluxePizza(addedToppings, diamter, slices);
            System.out.println(p);
        }catch (Exception e) {
            System.err.println("Cannot input information");
        }

    }
}