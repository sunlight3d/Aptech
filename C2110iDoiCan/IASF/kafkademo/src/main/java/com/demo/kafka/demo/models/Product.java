package com.demo.kafka.demo.models;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
@Builder

public class Product implements Serializable {
    private Long id;
    private String name;
    private Float price;

}
