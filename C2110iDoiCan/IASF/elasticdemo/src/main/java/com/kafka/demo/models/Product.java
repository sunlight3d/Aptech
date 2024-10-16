package com.kafka.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "products")
@Data
//Event-driven approach with Spring Data JPA
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 350)
    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Float)
    private Float price;

    @Field(type = FieldType.Text)
    @Column(name = "thumbnail", length = 300)
    private String thumbnail;

    @Column(name = "description")
    @Field(type = FieldType.Text, name = "description")
    private String description;

}