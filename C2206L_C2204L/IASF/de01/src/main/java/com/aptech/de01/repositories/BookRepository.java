package com.aptech.de01.repositories;

import com.aptech.de01.models.Book;
import com.aptech.de01.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    /*
    @Query("SELECT DISTINCT b.category FROM Book b")
    List<String> getCategoryNames();
    */

}
