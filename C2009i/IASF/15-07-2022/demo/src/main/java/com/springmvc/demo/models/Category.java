package com.springmvc.demo.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO - Plain Object Java Object
@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter @Setter
public class Category {
    @Id
    @Column(name = "categoryID")
    private String categoryID;
    @Column(name = "categoryName")
    private String categoryName;
    private String description;

}
