package com.aptech.ex001.repositories;

import com.aptech.ex001.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Search products by name (case insensitive) with pagination and sorting
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
}