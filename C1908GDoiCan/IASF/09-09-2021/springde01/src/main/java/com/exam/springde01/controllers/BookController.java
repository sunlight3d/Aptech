package com.exam.springde01.controllers;

import com.exam.springde01.models.Book;
import com.exam.springde01.models.Category;
import com.exam.springde01.services.IBookService;
import com.exam.springde01.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/list_all_books")
    String listAllBooks(Model model) {
        List<Book> books = bookService.listAllBooks();
        model.addAttribute("books", books);
        return "list_all_books";
    }
    @GetMapping("/insert_book")
    String insertBook(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "insert_book";
    }
    @PostMapping("/insert_book")
    String insertNewBook(Model model) {
        String title = model.getAttribute("title").toString();
        String categoryName = model.getAttribute("categoryName").toString();
        Long categoryId = categoryService.findByCategoryName(categoryName).getCategoryId();
        Float price = Float.valueOf(model.getAttribute("price").toString());
        bookService.insertNewBook(new Book(title, price, categoryId));
        return this.listAllBooks(model);
    }

    @DeleteMapping("/{id}")
    String deleteUser(Model model, @PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return this.listAllBooks(model);
        }catch (Exception exception) {
            model.addAttribute("error", exception.getMessage());
            //return "list_all_books";
            return this.listAllBooks(model);
        }
    }

}
