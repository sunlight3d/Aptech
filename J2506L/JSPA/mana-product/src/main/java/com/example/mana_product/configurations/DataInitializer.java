package com.example.mana_product.configurations;

import com.example.mana_product.models.Category;
import com.example.mana_product.models.Product;
import com.example.mana_product.repositories.CategoryRepository;
import com.example.mana_product.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(
            CategoryRepository categoryRepository,
            ProductRepository productRepository
    ) {
        return args -> {

            // Tránh insert trùng khi restart app
            if (categoryRepository.count() > 0) return;

            // Category
            Category laptop = Category.builder()
                    .categoryname("Laptop")
                    .build();

            Category phone = Category.builder()
                    .categoryname("Phone")
                    .build();

            // Product
            Product p1 = Product.builder()
                    .productName("MacBook Pro")
                    .price(2500.0)
                    .category(laptop)
                    .build();

            Product p2 = Product.builder()
                    .productName("Dell XPS")
                    .price(2500.0)
                    .category(laptop)
                    .build();

            Product p3 = Product.builder()
                    .productName("iPhone 15")
                    .price(2500.0)
                    .category(laptop)
                    .build();


            laptop.setProducts(List.of(p1, p2));
            phone.setProducts(List.of(p3));
            categoryRepository.saveAll(List.of(laptop, phone));
            productRepository.saveAll(List.of(p1, p2, p3));
        };
    }
}
