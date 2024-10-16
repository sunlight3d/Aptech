package com.de11.de11.services;
import com.de11.de11.models.Product;
import com.de11.de11.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> searchProducts(String searchTerm, Pageable pageable) {
        return productRepository.findBySearchTerm(searchTerm, pageable);
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
