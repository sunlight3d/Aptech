package com.aptech.de01.controllers;
import com.aptech.de01.models.Book;
import com.aptech.de01.repositories.BookRepository;
import com.aptech.de01.viewmodels.user.BookViewModel;
import com.aptech.de01.viewmodels.user.LoginViewModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;
    @GetMapping("")
    public String home(Model model) {
        return "book/home";//view's name
    }

    @GetMapping("insert-book")
    public String createBook() {
        // Add logic to save the book to the database using your service
        return "book/insert-book"; // Redirect to the list of books after insertion
    }
    @PostMapping("insert-book")
    @Transactional
    public String insertBook(@ModelAttribute BookViewModel bookViewModel) {
        Book book = Book.builder()
                .category(bookViewModel.getCategory())
                .title(bookViewModel.getTitle())
                .price(bookViewModel.getPrice())
                .build();
        bookRepository.save(book);
        return "redirect:/books/list-all-books";
    }

    @PostMapping("delete-book/{id}")
    @Transactional
    public String deleteBook(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return "redirect:/books/list-all-books";
    }

    // Mapping to handle logout (assuming a POST request)
    @GetMapping("list-all-books")
    public String listAllBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book/list-books";
    }
}