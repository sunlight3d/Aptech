/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech;

import javax.ejb.Remote;
import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author sunli
 */
@Local
public interface LibrarySessionBeanRemote {
    void addBook(String bookName);
    List getBooks();
}
