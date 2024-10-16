package com.exam.springde01.services;

import com.exam.springde01.models.*;

import java.util.List;

public interface IBookService {
    public List<Book> listAllBooks();
    public void insertNewBook(Book newBook);
    public void deleteBook(Long bookId);
}
