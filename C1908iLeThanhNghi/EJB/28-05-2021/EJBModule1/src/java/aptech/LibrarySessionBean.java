/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class LibrarySessionBean implements LibrarySessionBeanRemote {
    List<String> bookShelf;    
   
   public LibrarySessionBean() {
      bookShelf = new ArrayList<String>();
   }
    
   public void addBook(String bookName) {
      bookShelf.add(bookName);
   }    
 
   public List<String> getBooks() {
      return bookShelf;
   }
}
