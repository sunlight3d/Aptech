package com.aptech.de02.services.product;

import com.aptech.de02.dtos.AssignProductCategoryDTO;
import com.aptech.de02.models.Category;
import com.aptech.de02.models.Product;
import com.aptech.de02.repositories.CategoryRepository;
import com.aptech.de02.repositories.ProductRepository;
import com.aptech.de02.services.category.ICategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void assignProductoCategory(AssignProductCategoryDTO assignDTO) {
        String categoryId = assignDTO.getCategoryId();
        String productName = assignDTO.getProductName();

        // Lấy thông tin về danh mục và sản phẩm từ categoryId và productName
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        Product product = productRepository.findByProductName(productName);

        categoryOptional.ifPresent(category -> {
            if (product != null) {
                product.setCategory(category);
                productRepository.save(product);
            }
        });
    }
}
