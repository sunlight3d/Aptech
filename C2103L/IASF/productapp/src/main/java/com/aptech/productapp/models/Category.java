package com.aptech.productapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private String description;
}
