package vn.aptech.servlet.student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "STUDENTS")
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "born_year", nullable = false)
    private Integer bornYear = 0;

    public Student() {
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

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public int getAge() {
        if (bornYear == null) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return cal.get(Calendar.YEAR) - bornYear;
    }
}

/*
CREATE TABLE student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    born_year INT NOT NULL
);

INSERT INTO student (name, email, born_year) VALUES
('Nguyen Van A', 'nguyenvana@example.com', 1995),
('Le Thi B', 'lethib@example.com', 1996),
('Tran Van C', 'tranvanc@example.com', 1997),
('Hoang Thi D', 'hoangthid@example.com', 1998),
('Pham Van E', 'phamvane@example.com', 1999),
('Dang Thi F', 'dangthif@example.com', 2000),
('Vu Van G', 'vuvang@example.com', 2001),
('Bui Thi H', 'buithih@example.com', 2002),
('Ngo Van I', 'ngovani@example.com', 2003),
('Do Thi K', 'dothik@example.com', 2004);


* */