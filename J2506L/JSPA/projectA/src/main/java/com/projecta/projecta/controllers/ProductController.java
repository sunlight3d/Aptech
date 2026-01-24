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
    //http://localhost:8086/api/products
    @PostMapping
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
                .body(service.create(product));
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
        Product product = new Product();
        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        product.setStatus(dto.getStatus());

        return ResponseEntity.ok(service.update(id, product));
    }

    // 204 NO CONTENT
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
/*
curl -i -X POST http://localhost:8086/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Iphone 15",
    "quantity": 10,
    "status": "ACTIVE",
    "price": 25000000
  }'

curl -i -X POST http://localhost:8086/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "",
    "quantity": -1,
    "status": "ENABLE",
    "price": null
  }'

curl -i -X GET http://localhost:8086/api/products

curl -X GET http://localhost:8086/api/products/1

curl -X PUT http://localhost:8086/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Iphone 15 Pro",
    "quantity": 20,
    "status": "INACTIVE",
    "price": 30000000
  }'

curl -X DELETE http://localhost:8086/api/products/2

* */