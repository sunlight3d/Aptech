package com.projecta.projecta.controllers;

import com.projecta.projecta.dtos.requests.product.ProductRequestDTO;
import com.projecta.projecta.models.Product;
import com.projecta.projecta.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    @PostMapping()
    //http://localhost:8086/api/products
    public ResponseEntity<Product> create(
            @Valid @RequestBody ProductRequestDTO dto
    ) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        product.setStatus(dto.getStatus());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(product));
    }
    // 200 OK
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    // 200 / 404
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO dto
    ) {
        Product product = service.findById(id);
        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        product.setStatus(dto.getStatus());

        return ResponseEntity.ok(service.save(product));
    }
    // 204 NO CONTENT
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
