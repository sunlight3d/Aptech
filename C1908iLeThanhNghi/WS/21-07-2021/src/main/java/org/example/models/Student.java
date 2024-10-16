package org.example.models;

import javax.persistence.*;
/*
create table tblStudent(
    id integer PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(200),
    lastName VARCHAR(200)
);
* */
@Entity
@Table(name = "tblStudent")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="firstName", nullable = false, length = 200)
    private String firstName;

    @Column(name="lastName", nullable = false, length = 200)
    private String lastName;
    //buoc tiep theo => tao file persistence.xml

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
