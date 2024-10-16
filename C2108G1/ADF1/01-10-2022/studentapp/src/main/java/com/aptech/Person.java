package com.aptech;

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
