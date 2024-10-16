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
@Table(name = "schedulers")
public class Scheduler {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Sử dụng auto increment
    private Long id;

    @Column(name = "time_slot")
    private String timeSlot;

    @Column(name = "location")
    private String location;

    @Column(name = "exam_sitter")
    private String examSitter;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

}
