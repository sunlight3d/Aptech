package com.example.de03.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "roll_no")
    private String rollNo;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "class_name")
    private String className;
}
