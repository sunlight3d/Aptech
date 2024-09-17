package com.aptech.de12.controllers;

import com.aptech.de12.models.Book;
import com.aptech.de12.repositories.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    @Autowired
    private final BookRepository bookRepository;

    @GetMapping("")
    //gia tri tra ve la ten/path cua view
    public String index(Model model) {
        //query to db
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book/books"; //file books.html, located at .../resources/template/book/books.html
    }
    @GetMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("book", new Book()); // Add an empty Book object for the form binding
        return "book/insert";
    }

    @PostMapping("/insert")
    public String create(@ModelAttribute Book book, Model model) {
        // Save the book to the database
        bookRepository.save(book);

        // Redirect to the list page after insertion
        return "redirect:/books"; // Redirect to avoid duplicate form submission
    }

}