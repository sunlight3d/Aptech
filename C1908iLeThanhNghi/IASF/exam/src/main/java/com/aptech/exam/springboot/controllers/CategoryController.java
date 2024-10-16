package com.aptech.exam.springboot.controllers;

import com.aptech.exam.springboot.models.Category;
import com.aptech.exam.springboot.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    //service injection
    @Autowired
    private final CategoryRepository categoryRepository;
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("/viewCategories")
    public String viewCategories(Model model) {
        //model, giong ViewBag ben .NET
        model.addAttribute("categories", categoryRepository.findAll());
        return "category";//tim den file category.jsp
    }
    //add faked category
    @PostMapping(path="/insertCategory")
    public @ResponseBody String insertCategory (
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String description
            ) {
        Category category = new Category(id, name, description);
        categoryRepository.save(category);
        return "Saved";
    }
}
