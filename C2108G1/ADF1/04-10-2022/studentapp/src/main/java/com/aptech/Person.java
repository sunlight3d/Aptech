package com.aptech;

import java.util.Scanner;

public class Person {
    private String name;
    private Integer age;
    public Person(){}
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println(this.toString());
    }
    public void input() {
        System.out.println("Enter name: ");
        this.name = (new Scanner(System.in)).next();
        System.out.println("Enter age: ");
        this.age = (new Scanner(System.in)).nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name='" + name +
                ", age=" + age;
    }
}
