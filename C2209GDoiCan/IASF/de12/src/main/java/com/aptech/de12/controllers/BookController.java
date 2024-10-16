package com.aptech.de12.controllers;

import com.aptech.de12.models.Book;
import com.aptech.de12.repositories.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    // Method to display the edit form
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "book/edit"; // Return to a view named book/edit.html
    }

    // Method to handle form submission for updating the book
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Book book, Model model) {
        // Find existing book and update its details
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        bookRepository.save(existingBook); // Save updated book
        return "redirect:/books"; // Redirect to the books list after update
    }

    // Method to handle book deletion
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookRepository.delete(book); // Delete the book
        return "redirect:/books"; // Redirect to the books list after deletion
    }
}