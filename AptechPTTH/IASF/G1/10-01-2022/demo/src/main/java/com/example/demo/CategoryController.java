package com.example.demo;

import com.example.demo.models.Category;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
@RequestMapping(path="/category")
//http:localhost:8083/category
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello(ModelMap modelMap) {
        //modelMap giong ViewBag trong .NET MVC
        modelMap.addAttribute("x", "1");
        modelMap.addAttribute("y", "2");
        Iterable<Category> xxxx = categoryRepository.findAll();
        return "category"; //jsp file name: category.jsp
    }
}
