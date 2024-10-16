package com.aptech.productapp.controllers;

import com.aptech.productapp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.aptech.productapp.models.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;
    @GetMapping("")
    public String getCategories(Model model) {
        // Lấy danh sách các category từ database
        List<Category> categories = categoryRepository.findAll();
        // Đưa danh sách categories vào model để hiển thị trên category.jsp
        model.addAttribute("categories", categories);

        return "category";
    }
}

