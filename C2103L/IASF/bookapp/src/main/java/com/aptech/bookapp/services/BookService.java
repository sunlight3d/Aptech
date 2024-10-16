package com.aptech.bookapp.services;

import com.aptech.bookapp.models.Book;
import com.aptech.bookapp.repositories.BookRepository;
import com.aptech.bookapp.viewmodels.BookViewModel;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class BookService implements IBookService{
    private final BookRepository bookRepository;
    @Override
    public Book insertBook(BookViewModel bookViewModel) {
        Book book = Book.builder()
                .title(bookViewModel.getTitle())
                .price(bookViewModel.getPrice())
                .category(bookViewModel.getCategory())
                .build();
        return bookRepository.save(book);
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }
}
