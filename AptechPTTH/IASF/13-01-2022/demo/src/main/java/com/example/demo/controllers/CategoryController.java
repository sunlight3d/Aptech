package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller //not RestController
@RequestMapping(path = "category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;//DI = Dependency Injection
    //http://localhost:8080/category
    @RequestMapping(value = "", method = RequestMethod.GET)
    //return name of jsp file, like "return View();" of .NET MVC
    public String getAllCategories(ModelMap modelMap) {
        //modelMap = ViewBag, ViewData
        modelMap.addAttribute("x", "123467788");
        Iterable<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "category"; //find view with name "category.jsp"
    }
}
