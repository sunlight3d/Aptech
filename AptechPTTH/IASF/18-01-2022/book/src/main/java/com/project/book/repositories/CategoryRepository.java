package com.project.book.repositories;

import com.project.book.model.Category;
import com.project.book.model.User;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {

}
