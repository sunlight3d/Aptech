package com.aptech.demo.controllers;

import com.aptech.demo.dtos.requests.UpdateProductRequest;
import com.aptech.demo.models.Category;
import com.aptech.demo.models.Product;
import com.aptech.demo.services.category.CategoryService;
import com.aptech.demo.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    @GetMapping("/{categoryId}")
    public String getProductByCategoryId(
            @PathVariable("categoryId") String categoryId,
            Model model
    ) {
        List<Product> products = productService.findProductByCategoryId(categoryId);
        model.addAttribute("products", products);
        return "product/list";
    }
    @GetMapping("/assign/{productId}")
    //this method call 2 services
    public String assignProductToOtherCategory(
            @PathVariable("productId") String productId,
            Model model
    ) {
        List<Category> categories = categoryService.findAll();
        Product product = productService.findById(productId);
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "product/assign";
    }
    @PostMapping("/assign")
    public String assignProductToCategory (
            //why not @RequestBody ?
            @RequestParam("productId") String productId,
            @RequestParam("categoryId") String categoryId) {
       try {
           Product product = productService.findById(productId);
           UpdateProductRequest updateProductRequest = UpdateProductRequest.builder()
                   .productName(product.getProductName())
                   .price(product.getPrice())
                   .description(product.getDescription())
                   .categoryId(categoryId)//important
                   .build();
           productService.updateProduct(productId, updateProductRequest);
           return "redirect:/products/"+categoryId;
       } catch (Exception e) {
           return "redirect:/products/assign/"+productId;
       }
    }
}

