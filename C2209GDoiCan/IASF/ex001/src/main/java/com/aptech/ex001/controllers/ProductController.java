package com.aptech.ex001.controllers;
import com.aptech.ex001.models.Product;
import com.aptech.ex001.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    //http://localhost:8082/products
    public String getProductList(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @PageableDefault(size = 10,
                            sort = "name",
                            direction = Sort.Direction.ASC)
            Pageable pageable,
            Model model) {
        //call ProductService to get products' list
        Page<Product> products = productService.getProducts(search, pageable);
        model.addAttribute("products", products);//ViewBag in .net core mvc
        model.addAttribute("search", search);
        return "product/products"; //"entity's name"/"views' name" or action's name
        //press Edit => ProductController => redirect to Edit Page
    }
    // Method to show the edit form
    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        // Fetch the product by id
        Product product = productService.findById(id);

        // Add the product to the model so that it can be displayed in the form
        model.addAttribute("product", product);

        // Return the name of the Thymeleaf template for editing the product
        return "product/editProduct";
    }
    // Method to handle the form submission for editing the product
    @PostMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable("id") Long id, Product product) {
        // Set the id of the product to ensure it updates the correct one
        product.setId(id);

        // Save the updated product details
        productService.updateProduct(product);

        // Redirect to the product list after successful update
        return "redirect:/products";
    }
    //delete => not redirect
}
