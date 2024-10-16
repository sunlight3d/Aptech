package com.aprotrain.tabdemo.models;

public class Student {
    private int id;
    private String fullName;
    private String email;
    private String url;
    private String phoneNumber;

    public Student(int id, String fullName, String email, String url, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.url = url;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
