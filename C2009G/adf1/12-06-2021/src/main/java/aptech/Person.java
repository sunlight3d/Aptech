package aptech;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    //constructor
    public Person(){}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
    public void display(){
        System.out.println(String.format("name = %s, age = %d", name, age));
    }
    public void input() {
        System.out.println("Enter your name: ");
        this.name = getScanner().next();
        System.out.println("Enter your age: ");
        this.age = getScanner().nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
