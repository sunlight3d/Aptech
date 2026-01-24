package com.projecta.projecta.models;
import com.projecta.projecta.models.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Min(0)
    @Column(nullable = false)
    private int quantity;

    //@Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private String status = Status.ACTIVE;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
