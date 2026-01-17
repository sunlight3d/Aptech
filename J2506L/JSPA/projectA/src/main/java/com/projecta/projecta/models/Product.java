package com.projecta.projecta.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Product {
    private Integer id;
    private String name;
    private double price;

}
