package com.exam.springde01.services;

import com.exam.springde01.models.Book;
import com.exam.springde01.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookService implements IBookService{
    @Autowired
    private BookRepository repository;
    @Override
    public List<Book> listAllBooks() {
        return repository.findAll();
    }

    @Override
    public void insertNewBook(Book newBook) {
        repository.save(newBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        Optional<Book> foundBook = repository.findById(bookId);
        if(foundBook.isPresent()) {
            repository.delete(foundBook.get());
        }

    }
}
