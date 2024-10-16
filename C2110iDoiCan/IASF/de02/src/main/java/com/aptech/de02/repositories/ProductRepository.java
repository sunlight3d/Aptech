package com.aptech.de02.repositories;


import com.aptech.de02.models.Category;
import com.aptech.de02.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String productName);
}
