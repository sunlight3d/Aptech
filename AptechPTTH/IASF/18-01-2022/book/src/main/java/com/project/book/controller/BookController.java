package com.project.book.controller;

import com.project.book.model.Book;
import com.project.book.model.Category;
import com.project.book.repositories.BookRepository;
import com.project.book.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String Welcome (ModelMap modelMap){
        if(httpSession.getAttribute("username") == null){
            return "redirect:/user/login";
        }
        httpSession.getAttribute("username");
        return "welcome";
    }

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String getBookList(ModelMap modelMap){
        if(httpSession.getAttribute("username") == null){
            return "redirect:/user/login";
        }
        List <Object> booksResults = bookRepository.getBooksAndCategory();
        ArrayList<Hashtable<String, Object>> books = new ArrayList<Hashtable<String, Object>>();
        for (Object eachObject: booksResults) {
            Hashtable<String, Object> hashtable = new Hashtable<>();
            hashtable.put("bookID", ((Object []) eachObject)[0]);
            hashtable.put("title", ((Object []) eachObject)[1]);
            hashtable.put("categoryName", ((Object []) eachObject)[2]);
            hashtable.put("price", ((Object []) eachObject)[3]);
            books.add(hashtable);
        }
        modelMap.addAttribute("books", books);
        return "booklist";
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public String deleteBook (ModelMap modelMap,
                              @RequestParam("bookID") String bookID){
        if(httpSession.getAttribute("username") == null){
            return "redirect:/user/login";
        }
        modelMap.addAttribute("bookid", bookID);
        return "ask";
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
    public String deleteBookConfirm (ModelMap modelMap, String bookId){

        try{
            Optional<Book> b =bookRepository.findById(bookId);
            if(b.isPresent()){
                Book selectedbook = b.get();
                bookRepository.delete(selectedbook);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return "redirect:/book/booklist";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String Insert (ModelMap modelMap){
        if(httpSession.getAttribute("username") == null){
            return "redirect:/user/login";
        }
        Iterable<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "insertbook";
    }

    @RequestMapping(value = "/insertconfirmed", method = RequestMethod.POST)
    public String AcceptToInsert (ModelMap modelMap, String title, String categoryID, String price){

        try{
            Book b = new Book(title, categoryID, Float.parseFloat(price));
            bookRepository.save(b);
        }catch (Exception e){
            System.out.println(e);
        }
        return "redirect:/book/booklist";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String Logout(ModelMap modelMap){
        httpSession.removeAttribute("username");
        return "redirect:/user/login";
    }
}
