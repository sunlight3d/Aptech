package com.aptech.exam.springboot.repositories;
import com.aptech.exam.springboot.models.Category;
import com.aptech.exam.springboot.models.Product;
import org.springframework.data.repository.CrudRepository;
public interface ProductRepository extends CrudRepository<Product, String> {
}
