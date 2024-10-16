package com.exam.springde01.services;

import com.exam.springde01.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category findByCategoryName(String categoryName);
}
