package com.aptech.demo.dtos.requests;

import lombok.*;
import java.time.LocalDate;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder //custom constructor
public class InsertStudentRequest {

    //@JsonProperty("name")
    private String name;

    //@JsonProperty("email")
    private String email;

    //@JsonProperty("dob")
    private LocalDate dob;

    //@JsonProperty("major")
    private String major;

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
