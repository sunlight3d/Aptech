package com.aptech.de02.controllers;

import com.aptech.de02.models.Category;
import com.aptech.de02.models.Product;
import com.aptech.de02.repositories.CategoryRepository;
import com.aptech.de02.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products") //routing
@RequiredArgsConstructor
//url path to this controller
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @GetMapping("")
    public String index(
            @RequestParam(value = "categoryId", required = false) String categoryId,
            Model model){
        List<Product> products = categoryId == null ?
                productRepository.findAll():
                productRepository.findByCategoryCategoryId(categoryId);
        //ViewBag.products = products;
        model.addAttribute("products", products);
        return "products/index";
    }
    @GetMapping("/assign/{productId}")
    public String assignProductToCategory(
            @PathVariable("productId") String productId, Model model) {
        Product selectedProduct = productRepository.findById(productId)
                .orElse(null);
        Category currentCategory = selectedProduct.getCategory();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("currentCategory", currentCategory);
        model.addAttribute("selectedProduct", selectedProduct);
        model.addAttribute("categories", categories);
        return "products/assignProductToCategory";
    }
    @PostMapping("/assign")
    //@Transactional
    public String assignProductToCategory
            (@RequestParam("productId") String productId,
             @RequestParam("categoryId") String categoryId) {

        Product selectedProduct = productRepository.findById(productId).orElse(null);
        Category selectedCategory = categoryRepository.findById(categoryId).orElse(null);
        selectedProduct.setCategory(selectedCategory);
        productRepository.save(selectedProduct);
        
        // Redirect to a success page or another appropriate URL
        return "redirect:/products";
    }
}
