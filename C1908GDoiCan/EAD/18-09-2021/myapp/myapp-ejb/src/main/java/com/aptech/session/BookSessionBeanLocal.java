/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.session;

import com.aptech.entities.*;
import java.util.*;
import javax.ejb.Local;

@Local
public interface BookSessionBeanLocal {
    List<Book> findAll();
    void insert(Book book);
    void delete(String bookCode);
    void update(Book book);
}
