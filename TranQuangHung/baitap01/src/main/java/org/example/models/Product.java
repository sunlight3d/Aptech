package org.example.models;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Getter @Setter
@NoArgsConstructor
@Data
public class Product {
    private Long id;
    private String name;
    private double price;

    private int count;
    private String brandName;
    private Long categoryId;

    /*

    public Product(Long id, String name, double price, String brandName, Long categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brandName = brandName;
        this.categoryId = categoryId;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
     */

}
