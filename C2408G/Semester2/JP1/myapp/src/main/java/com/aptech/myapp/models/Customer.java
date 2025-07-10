package com.aptech.myapp.models;

public class Customer extends Object{
    private Integer id;
    private String name;
    private int age;
    private String address;

    //initialization block
    {
        System.out.println("before constructor");
        id = 1;
        name = "";
    }
    public Customer(Integer id, String name, int age, String address) {
        //Hay cho vi du ve all arguments constructor dung lombok
        System.out.println("all arguments constructor");
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }


    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'';
    }

    public Customer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
