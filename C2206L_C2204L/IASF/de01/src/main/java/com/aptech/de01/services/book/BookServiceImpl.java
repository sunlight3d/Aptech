package com.aptech.de01.services.book;

import com.aptech.de01.dtos.requests.BookRequest;
import com.aptech.de01.dtos.responses.BookResponse;
import com.aptech.de01.models.Book;
import com.aptech.de01.repositories.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    @Override
    public List<BookResponse> findAll() {
        List<Book> books = bookRepository.findAll();
        /*
        return books.stream()
                .map(book ->
                        new BookResponse(
                                book.getId(),
                                book.getTitle(),
                                book.getCategory(),
                                book.getPrice()))
                .collect(Collectors.toList());
         */
        return books.stream()
                .map(book ->
                        BookResponse.builder()
                                .id(book.getId())
                                .title(book.getTitle())
                                .category(book.getCategory())
                                .price(book.getPrice())
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void insert(BookRequest bookRequest) {
        //convert Request to Model
        Book newBook = Book.builder()
                .title(bookRequest.getTitle())
                .price(bookRequest.getPrice())
                .category(bookRequest.getCategory())
                .build();
        bookRepository.save(newBook);
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
