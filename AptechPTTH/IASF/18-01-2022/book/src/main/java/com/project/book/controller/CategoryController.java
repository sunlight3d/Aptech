package com.project.book.controller;

import com.project.book.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path= "category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;//DI = Dependency Injection

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllCategories(ModelMap modelMap) {
        modelMap.addAttribute("x", "123456");

        return "categorylist";
    }
}
