package com.aptech.exam.springboot.repositories;
import com.aptech.exam.springboot.models.Category;
import org.springframework.data.repository.CrudRepository;
public interface CategoryRepository extends CrudRepository<Category, String> {
}
