package com.example.mana_product.services;

import com.example.mana_product.dtos.ProductCreateRequestDTO;
import com.example.mana_product.dtos.ProductResponseDTO;
import com.example.mana_product.models.Product;
import com.example.mana_product.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // Lombok tự tạo constructor injection
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public Page<ProductResponseDTO> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map((Product p) -> new ProductResponseDTO(
                        p.getId(),
                        p.getProductName(),
                        p.getPrice()));
    }

    public Page<ProductResponseDTO> search(String keyword, Pageable pageable) {

        return productRepository.findByNameContainingIgnoreCase(keyword, pageable)
                .map((Product p) -> ProductResponseDTO.builder()
                        .id(p.getId())
                        .name(p.getProductName())
                        .price(p.getPrice()).build());

    }
    @Transactional // Cần ghi vào DB nên bỏ readOnly
    public ProductResponseDTO create(ProductCreateRequestDTO request) {
        Product product = Product.builder()
                .productName(request.getName())
                .price(request.getPrice())
                .build();

        Product savedProduct = productRepository.save(product);
        return new ProductResponseDTO(
                savedProduct.getId(),
                savedProduct.getProductName(),
                savedProduct.getPrice());
    }
    @Transactional
    public void delete(Long id) throws Exception {
        if (!productRepository.existsById(id)) {
            throw new Exception("Product not found");
        }
        productRepository.deleteById(id);
    }
}