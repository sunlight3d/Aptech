package com.kafka.demo.controllers;

import com.kafka.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kafka.demo.models.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam("query") String query, Pageable pageable) {
        Page<Product> productsPage = productRepository.findByNameContainingOrDescriptionContaining
                (query,query, pageable);
        return productsPage.getContent();
    }
    @GetMapping("/test")
    public ResponseEntity<?> testInsert() {
        Product product = Product.builder()
                .name("iphone 15")
                .thumbnail("aaa")
                .price(123.4f)
                .build();
        productRepository.save(product);
        return ResponseEntity.ok("Haha");
    }
}