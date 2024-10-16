package com.aptech.productapp.configurations;

import com.aptech.productapp.models.Category;
import com.aptech.productapp.models.Product;
import com.aptech.productapp.repositories.CategoryRepository;
import com.aptech.productapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataConfig {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    @Bean
    public void generateData() {
        if(categoryRepository.count() == 0) {
            categoryRepository.save(Category.builder()
                            .name("Beverages")
                            .id(1L)
                            .description("This is beverages")
                    .build());
            categoryRepository.save(Category.builder()
                    .name("Seafood")
                    .id(2L)
                    .description("This is Seafood")
                    .build());
            categoryRepository.save(Category.builder()
                    .name("Condiments")
                    .id(3L)
                    .description("This is Condiments")
                    .build());
        }
        if(productRepository.count() == 0) {
            productRepository.save(Product.builder()
                    .name("product 111")
                            .price(123)
                            .category(categoryRepository.findById(1L).get())
                    .build());
            productRepository.save(Product.builder()
                    .name("product 222")
                    .price(222)
                    .description("This is p 222")
                    .category(categoryRepository.findById(1L).get())
                    .build());
            productRepository.save(Product.builder()
                    .name("product 333")
                    .description("This is p 333")
                    .price(333)
                    .category(categoryRepository.findById(2L).get())
                    .build());
            productRepository.save(Product.builder()
                    .name("product 444")
                    .description("This is p 444")
                    .price(444)
                    .category(categoryRepository.findById(3L).get())
                    .build());
        }
    }
}
