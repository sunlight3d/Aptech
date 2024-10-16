package com.aptech.ex001.services;
import com.aptech.ex001.models.Product;
import com.aptech.ex001.repositories.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
//service, repository are called "components"
@Service
@Getter
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Page<Product> getProducts(String searchQuery, Pageable pageable) {
        if (searchQuery == null || searchQuery.isEmpty()) {
            return productRepository.findAll(pageable);  // Return all products if search query is empty
        } else {
            return productRepository.findByNameContainingIgnoreCase(searchQuery, pageable);  // Filter by name
        }
    }
    // Method to find a product by its ID
    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Method to update a product (save an existing product)
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    // Method to add a new product
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    // Method to perform soft delete (mark the product as deleted)
    public void deleteProduct(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }
}
