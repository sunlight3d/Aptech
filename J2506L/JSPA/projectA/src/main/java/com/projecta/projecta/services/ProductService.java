package com.projecta.projecta.services;

import com.projecta.projecta.models.Product;
import com.projecta.projecta.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    // CREATE / UPDATE
    public Product save(Product product) {
        return repository.save(product);
    }

    // READ ALL
    public List<Product> findAll() {
        return repository.findAll();
    }

    // READ BY ID
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    // DELETE
    public void delete(Long id) {
        Product product = findById(id);
        repository.delete(product);
    }
}