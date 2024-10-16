package com.kafka.demo.repositories;
import com.kafka.demo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {
    Page<Product> findByNameContainingOrDescriptionContaining
            (String name, String description, Pageable pageable);
}