package com.example.mana_product.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    private Double price;

    // Nhiều Product thuộc về 1 Category
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
