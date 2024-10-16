package com.example.de03.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
@Table(name = "exam_attendance")
public class ExamAttendance {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "scheduler_id")
    private Scheduler scheduler;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
