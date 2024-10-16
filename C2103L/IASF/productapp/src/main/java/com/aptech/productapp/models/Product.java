package com.aptech.productapp.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name="products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String description;

    @ManyToOne
    private Category category; // ID của category mà sản phẩm thuộc về
}
