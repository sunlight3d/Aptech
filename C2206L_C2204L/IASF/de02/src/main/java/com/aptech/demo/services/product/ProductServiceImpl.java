package com.aptech.demo.services.product;

import com.aptech.demo.dtos.requests.UpdateProductRequest;
import com.aptech.demo.exceptions.DataNotfoundException;
import com.aptech.demo.models.Category;
import com.aptech.demo.models.Product;
import com.aptech.demo.repositories.CategoryRepository;
import com.aptech.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    @Transactional
    public void updateProduct(String productId, UpdateProductRequest productRequest)
            throws DataNotfoundException {
        //Optional<Product> optionalProduct = productRepository.findById(productId);
        Product selectedProduct = productRepository.findById(productId)
                .orElseThrow(DataNotfoundException::new);
        if (productRequest.getProductName() != null) {
            selectedProduct.setProductName(productRequest.getProductName());
        }
        if (productRequest.getPrice() != null) {
            selectedProduct.setPrice(productRequest.getPrice());
        }
        if (productRequest.getDescription() != null) {
            selectedProduct.setDescription(productRequest.getDescription());
        }
        if (productRequest.getCategoryId() != null) {
            Category category = categoryRepository.findById(productRequest.getCategoryId())
                    .orElseThrow(DataNotfoundException::new);
            selectedProduct.setCategory(category);
        }
    }

    @Override
    public List<Product> findProductByCategoryId(String categoryId) {
        return productRepository.findProductByCategoryId(categoryId);
    }

    @Override
    public Product findById(String productId) {
        return productRepository.findById(productId).get();
    }
}
