package com.aptech.de01.repositories;

import com.aptech.de01.models.Book;
import com.aptech.de01.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}