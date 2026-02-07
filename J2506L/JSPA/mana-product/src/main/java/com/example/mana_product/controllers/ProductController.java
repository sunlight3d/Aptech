package com.example.mana_product.controllers;

import com.example.mana_product.dtos.ProductCreateRequestDTO;
import com.example.mana_product.dtos.ProductResponseDTO;
import com.example.mana_product.services.ProductService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> getProducts(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }
    @GetMapping("/search")
    public ResponseEntity<Page<ProductResponseDTO>> search(@RequestParam String keyword, Pageable pageable) {
        return ResponseEntity.ok(productService.search(keyword, pageable));
    }
    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(
            @Valid @RequestBody ProductCreateRequestDTO dto) {
        return new ResponseEntity<>(
                productService.create(dto),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
