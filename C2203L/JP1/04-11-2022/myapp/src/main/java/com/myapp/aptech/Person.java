package com.myapp.aptech;

import java.util.Scanner;

public class Person {
    private String name; //instance fields
    private Integer age;//instance fields

    public void input(){
        System.out.println("Enter name: ");
        this.name = (new Scanner(System.in)).next();

        System.out.println("Enter age: ");
        this.age = (new Scanner(System.in)).nextInt();
    }
    public void display() {
//        System.out.println("name: "+this.name +
//                "age: "+this.age);
        System.out.println(String.format("name: %s, age: %d\n", name,age));
    }
    //getter
    public String getName() {
        return name;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    //public abstract void doSomething();//no implementation
}
