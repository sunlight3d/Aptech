package com.aptech.apidemo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    private @Id @GeneratedValue Long id;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String generatedPassword;
    private String tokenKey;

    public User() {}
    //to access User object => Repository
    public User(String email, String fullName, String phoneNumber) {
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    //2 đối tượng như thế nào đc gọi là "giống nhau về nội dung" ?
    //thực thi phương thức equals
    @Override
    public boolean equals(Object otherUser) {
        if (this == otherUser) return true;
        if (otherUser == null || getClass() != otherUser.getClass()) return false;
        User user = (User) otherUser;
        return email.equals(user.email) &&
                fullName.equals(user.fullName) &&
                phoneNumber.equals(user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, fullName, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", generatedPassword='" + generatedPassword + '\'' +
                ", tokenKey='" + tokenKey + '\'' +
                '}';
    }
}
