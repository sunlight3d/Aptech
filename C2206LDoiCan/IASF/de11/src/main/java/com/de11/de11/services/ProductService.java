package com.de11.de11.services;
import com.de11.de11.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> searchProducts(String searchTerm, Pageable pageable);
    void deleteProduct(Long id);
}

