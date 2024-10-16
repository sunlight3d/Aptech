package com.aptech.de02.services.product;

import com.aptech.de02.dtos.AssignProductCategoryDTO;
import com.aptech.de02.models.Category;
import com.aptech.de02.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void assignProductoCategory(AssignProductCategoryDTO assignDTO);
}