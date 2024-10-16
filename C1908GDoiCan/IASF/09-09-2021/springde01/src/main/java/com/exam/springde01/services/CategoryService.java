package com.exam.springde01.services;

import com.exam.springde01.models.Category;
import com.exam.springde01.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService implements ICategoryService{
    @Autowired
    private CategoryRepository repository;
    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }
    public Category findByCategoryName(String categoryName) {
        return repository.findByCategoryName(categoryName);
    }
}
