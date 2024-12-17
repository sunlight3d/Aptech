package com.aptech.demo.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "students")
@Getter @Setter
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
}
