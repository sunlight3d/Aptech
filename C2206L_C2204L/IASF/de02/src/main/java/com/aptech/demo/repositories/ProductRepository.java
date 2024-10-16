package com.aptech.demo.repositories;

import com.aptech.demo.models.Category;
import com.aptech.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findProductByCategoryId(String categoryId);
}