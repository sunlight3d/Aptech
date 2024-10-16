package com.exam.springde01.repositories;

import com.exam.springde01.models.Book;
import com.exam.springde01.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByCategoryName(String categoryName);
}
