package com.example.myapp.models;

import java.io.Serializable;

public class Person implements Serializable {
    private int personId;
    private String name;
    private String email;

    public Person(int personId, String name, String email) {
        this.personId = personId;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
