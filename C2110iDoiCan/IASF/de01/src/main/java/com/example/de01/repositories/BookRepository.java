package com.example.de01.repositories;

import com.example.de01.models.Book;
import com.example.de01.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
