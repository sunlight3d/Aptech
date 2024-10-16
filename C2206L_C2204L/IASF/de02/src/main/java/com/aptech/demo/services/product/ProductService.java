package com.aptech.demo.services.product;

import com.aptech.demo.dtos.requests.UpdateProductRequest;
import com.aptech.demo.exceptions.DataNotfoundException;
import com.aptech.demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    void updateProduct(String productId,
                       UpdateProductRequest productRequest) throws DataNotfoundException;
    List<Product> findProductByCategoryId(String categoryId);
    Product findById(String productId);
}
