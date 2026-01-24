package com.projecta.projecta.repositories;

import com.projecta.projecta.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByStatus(String status);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
    boolean existsByName(String name);
}
