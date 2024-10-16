package com.aptech;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String s = "Welcome to Aptech";
        //String s = "          Junit working         finen jiuwew                    jijij            jeje";
        Question01 question01 = new Question01();
        System.out.println("count = " + question01.countWord(s));
        //bai 2
        ArrayList<Student> students = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Student student = new Student();
            student.input();
        }
    }
}