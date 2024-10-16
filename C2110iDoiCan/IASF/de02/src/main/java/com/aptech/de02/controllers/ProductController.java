package com.aptech.de02.controllers;


import com.aptech.de02.dtos.AssignProductCategoryDTO;
import com.aptech.de02.models.Category;
import com.aptech.de02.models.Product;
import com.aptech.de02.services.category.CategoryService;
import com.aptech.de02.services.category.ICategoryService;
import com.aptech.de02.services.product.IProductService;
import com.aptech.de02.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;
    private final ICategoryService categoryService;
    //http:localhost:8088
    @GetMapping("")
    public String listCategories(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/listProducts"; //view's name
    }
    @GetMapping("/assign/{productName}")
    public String assign(@PathVariable String productName, Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("productName", productName);
        return "product/assign"; // Tên view
    }
    @PostMapping("/assignProductoCategory")
    public String assignProductoCategory(@RequestBody AssignProductCategoryDTO assignDTO)
    {
        productService.assignProductoCategory(assignDTO);
        return "redirect:/products"; // Chuyển hướng về trang danh sách sản phẩm
    }
}