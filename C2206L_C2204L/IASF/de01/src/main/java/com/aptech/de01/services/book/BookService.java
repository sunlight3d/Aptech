package com.aptech.de01.services.book;

import com.aptech.de01.dtos.requests.BookRequest;
import com.aptech.de01.dtos.responses.BookResponse;
import com.aptech.de01.models.Book;

import java.util.List;

public interface BookService {
    List<BookResponse> findAll();
    void insert(BookRequest bookDTO);
    void delete(Long bookId);
}
