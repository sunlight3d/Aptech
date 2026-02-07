package com.example.mana_product.repositories;

import com.example.mana_product.models.Category;
import com.example.mana_product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
