package com.aptech.bookapp.controllers;

import com.aptech.bookapp.models.Book;
import com.aptech.bookapp.services.IBookService;
import com.aptech.bookapp.viewmodels.BookViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor

public class BookController {
    private final IBookService bookService;
    @GetMapping("listBooks")
    public ModelAndView listBooks(Model model) {
        ModelAndView modelAndView = new ModelAndView("book/list_book");
        List<Book> books = bookService.listBooks();
        model.addAttribute(books);
        return modelAndView;
    }
    @GetMapping("insertBook")
    public ModelAndView insertBook(Model model) {
        return new ModelAndView("book/insert_book");
    }
    @PostMapping("insertBook")
    public ModelAndView createBook(Model model) {
        ModelAndView modelAndView = new ModelAndView("book/insert_book");
        modelAndView.addObject("bookViewModel", new BookViewModel());
        return modelAndView;
    }
}
