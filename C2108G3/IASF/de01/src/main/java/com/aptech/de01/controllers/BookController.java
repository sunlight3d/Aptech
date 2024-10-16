package com.aptech.de01.controllers;

import com.aptech.de01.models.Book;
import com.aptech.de01.models.User;
import com.aptech.de01.repositories.BookRepository;
import com.aptech.de01.repositories.UserRepository;
import com.aptech.de01.viewmodels.BookViewModel;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    //inject book's repository
    private final BookRepository bookRepository;
    //private final CategoryRepository categoryRepository;
    @GetMapping("")
    //Home's book
    public String welcome(Model model) {
        return "books/welcome";
    }
    @GetMapping("insert")
    public String insert(Model model) {

        return "books/insert";
    }
    @PostMapping("insert")
    @Transactional
    public String create(
            @ModelAttribute("bookViewModel") BookViewModel bookViewModel,
            Model model) {
        //create book from book viewmodel
        //AutoMapper, Object Mapper,..
        Book book = Book.builder()
                .title(bookViewModel.getTitle())
                .category(bookViewModel.getCategory())
                .price(bookViewModel.getPrice())
                .id(0)
                .build();
        bookRepository.save(book);
        return "redirect:/books/listbooks";
    }
    @PostMapping("logout")
    public String logout(Model model, HttpSession session) {
        //clear session
        session.invalidate();
        return "redirect:users/login";
    }
    @GetMapping("listbooks")
    public String listbooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books/listbooks";
    }
    @PostMapping("delete")
    @Transactional
    public String deleteBook(@RequestParam("id") int bookId) {
        System.out.println("Deleting book with ID: " + bookId);
        bookRepository.deleteById(bookId);
        return "redirect:/books/listbooks";
    }
}
