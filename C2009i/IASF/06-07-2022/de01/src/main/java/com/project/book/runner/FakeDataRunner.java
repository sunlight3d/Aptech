package com.project.book.runner;

import com.project.book.model.Book;
import com.project.book.model.Category;
import com.project.book.model.User;
import com.project.book.repositories.BookRepository;
import com.project.book.repositories.CategoryRepository;
import com.project.book.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Log4j2
@Transactional
@AllArgsConstructor
//@Order(1)
public class FakeDataRunner implements CommandLineRunner {
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        //log.info("hahaha");
        categoryRepository.save(new Category(1L, "Nhat ky"));
        categoryRepository.save(new Category(2L, "Tan Van"));
        categoryRepository.save(new Category(3L, "Du lich"));
        userRepository.save(new User(1L, "hoangnd", "123456"));

        bookRepository.save(new Book(1L, "Mai mai tuoi 20", 123, 1L));
        bookRepository.save(new Book(2L, "Con ai hat ve Ha noi", 454, 2L));
        bookRepository.save(new Book(3L, "Mua thu ha noi", 222, 3L));

    }
}
