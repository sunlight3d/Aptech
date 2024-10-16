package com.product;

public class Person {
    public static int currentId = 0;
    private int personId;
    private String name;

    public Person(String name) {
        currentId++;
        personId = currentId;
        this.name = name;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
