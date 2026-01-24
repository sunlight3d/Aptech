package com.projecta.projecta.services;

import com.projecta.projecta.models.Product;
import com.projecta.projecta.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    // CREATE
    public Product create(Product product) {
        if (repository.existsByName(product.getName())) {
            throw new IllegalArgumentException(
                    "Product name already exists: " + product.getName()
            );
        }
        return repository.save(product);
    }

    // UPDATE
    public Product update(Long id, Product newData) {
        Product product = findById(id);

        // nếu đổi tên thì mới check trùng
        if (!product.getName().equals(newData.getName())
                && repository.existsByName(newData.getName())) {
            throw new IllegalArgumentException(
                    "Product name already exists: " + newData.getName()
            );
        }

        product.setName(newData.getName());
        product.setQuantity(newData.getQuantity());
        product.setPrice(newData.getPrice());
        product.setStatus(newData.getStatus());

        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found: " + id));
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}