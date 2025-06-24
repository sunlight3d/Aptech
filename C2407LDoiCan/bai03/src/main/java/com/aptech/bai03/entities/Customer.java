package com.aptech.bai03.entities;

public class Customer {
    private Integer id;
    private String name;
    private String address;
    private int age;
    //parameterized constructor
    public Customer(int id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //100 fields =
    //Builder pattern
    //methods

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void showInformation() {
        System.out.println(String.format(
                "id: %d," +
                " name = %s, " +
                "address = %s, " +
                "age = %d", id, name, address, age));
    }
}
