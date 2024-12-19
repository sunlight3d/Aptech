package com.aptech.demo.models;

import com.aptech.demo.dtos.requests.InsertStudentRequest;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "major", nullable = false)
    private String major;

    //factory method
    public static Student fromRequest(InsertStudentRequest request)  {
        //object mapper
        Student newStudent = new Student();
        newStudent.email = request.getEmail();
        newStudent.name = request.getName();
        newStudent.dob = request.getDob();
        newStudent.major = request.getMajor();
        return newStudent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
