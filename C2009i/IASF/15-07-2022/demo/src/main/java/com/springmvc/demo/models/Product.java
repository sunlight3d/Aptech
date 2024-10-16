package com.springmvc.demo.models;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "ProductID")
    private String productID;
    private String categoryID;
    @Column(name = "productName")
    private String productName;
    private int price;
    private String description;
    public String getFormattedPrice() {
        return String.format("$ %.2f", (price * 100.00) / 100.00);
    }
}
