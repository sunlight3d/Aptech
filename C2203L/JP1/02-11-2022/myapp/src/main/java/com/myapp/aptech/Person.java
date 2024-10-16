package com.myapp.aptech;

public abstract class Person {
    private String name; //instance fields
    private Integer age;//instance fields

    public void display() {
//        System.out.println("name: "+this.name +
//                "age: "+this.age);
        System.out.println(String.format("name: %s, age: %d", name,age));
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
    public abstract void doSomething();//no implementation
}
