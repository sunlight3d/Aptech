package com.example.mana_product.repositories;

import com.example.mana_product.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Tìm kiếm sản phẩm theo tên hoặc mô tả, có hỗ trợ phân trang
    // Thực tế: Nên dùng 'ContainingIgnoreCase' để tìm kiếm mượt hơn
    Page<Product> findByNameContainingIgnoreCase(String keyword, Pageable pageable);

}
