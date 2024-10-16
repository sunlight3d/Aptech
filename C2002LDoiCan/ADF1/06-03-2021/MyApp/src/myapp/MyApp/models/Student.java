/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.MyApp.models;

import java.util.Scanner;

/**
 *
 * @author sunli
 */
public class Student extends Person {
    private Float mark1, mark2;
    public Student(String name, String address) {
        super(name, address);
    }

    Student() {}
    public void inputMarks(){        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter mark1: ");
        this.mark1 = scanner.nextFloat();
        System.out.println("Enter mark2: ");
        this.mark2 = scanner.nextFloat();
    }
    public Float getTotalMarks() {
        return mark1 + mark2;
    }
    //Ham thay doi thong tin     
    @Override
    public void input() {
        super.input(); 
        inputMarks();
    }

    @Override
    public String toString() {
        return super.toString() + ",mark1=" + mark1 
                + ", mark2=" + mark2;
    }
    
}
