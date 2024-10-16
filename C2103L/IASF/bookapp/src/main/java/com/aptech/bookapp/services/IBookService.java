package com.aptech.bookapp.services;

import com.aptech.bookapp.models.Book;
import com.aptech.bookapp.viewmodels.BookViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {
    Book insertBook(BookViewModel bookViewModel);
    List<Book> listBooks();
}
