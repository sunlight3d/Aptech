package com.projecta.projecta.dtos.responses.product;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponseDTO {
    private Integer id;
    private String name;
    private int quantity;
    private String status;
    private Double price;
    private LocalDateTime createdAt;
}