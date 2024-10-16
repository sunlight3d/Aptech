package com.aptech.lythuyet.lythuyet;

public class Main {
    public static void main(String[] args) {
        char c1 = 064770;
        //char c2 = 'face';
        char c3 = 0xbeef;
        char c6 = '\uface';
        System.out.println("c1 = "+c6);
        Student student1 = new Student("aaa", 18);
        Student student2 = new Student("aaa", 18);
        if(student1.equals(student2)) {
            System.out.println("same content");
        }
        Object x = student1;
    }
}
