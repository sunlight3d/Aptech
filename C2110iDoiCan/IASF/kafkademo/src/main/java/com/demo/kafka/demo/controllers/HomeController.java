package com.demo.kafka.demo.controllers;
import com.demo.kafka.demo.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/home")
//curl http://localhost:8088/api/v1/home/sendProduct
public class HomeController {
    private final KafkaTemplate<Object, Object> kafkaTemplate;
    /*
    @GetMapping(path = "/sendListOfProducts")
    //send A List of objects
    public ResponseEntity<String> sendListOfString() {
        //send a list of object
        this.kafkaTemplate.executeInTransaction(kafkaTemplate -> {
            ArrayList<String> fakedStrings = new ArrayList<>();
            fakedStrings.add("red");
            fakedStrings.add("green");
            fakedStrings.add("blue");
            fakedStrings.stream().forEach(item -> kafkaTemplate.send("topic1", item));
            return null;
        });
        return ResponseEntity.ok().body("haha");
    }
     */

    //send an Object
    @GetMapping(path = "/sendProduct")
    public ResponseEntity<String> sendFoo() {
        try {
            Product product = Product.builder()
                    .name("ipohone 15")
                    .price(1234.9f)
                    .id(1L)
                    .build();
            product = new Product(2L, "iph 12", 122.3f);
            this.kafkaTemplate.send("product",
                    product);
            /*
            this.kafkaTemplate.executeInTransaction(kafkaTemplate -> {
                return Product.builder()
                        .name("ipohone 15")
                        .price(1234.9f)
                        .id(1L)
                        .build();
            });
             */
            return ResponseEntity.ok().body("haha");

        }catch (Exception e) {
            System.out.println("haha");
            return ResponseEntity.badRequest().body("haha");
        }
    }
}
