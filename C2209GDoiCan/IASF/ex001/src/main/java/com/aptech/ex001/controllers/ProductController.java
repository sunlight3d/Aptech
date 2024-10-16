package com.aptech.ex001.controllers;
import com.aptech.ex001.components.TripInfo;
import com.aptech.ex001.models.Product;
import com.aptech.ex001.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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

import org.springframework.data.domain.Pageable;

@Controller
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final TripInfo tripInfo; //where is contructor ?
    @Autowired
    private final ProductService productService;

    @GetMapping("/products")
// http://localhost:8082/products
    public String getProducts(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @PageableDefault(size = 10, sort = "name",
                    direction = Sort.Direction.ASC) Pageable pageable,
            Model model) {

        // Call ProductService to get the paginated and filtered list of products
        Page<Product> products = productService.getProducts(search, pageable);

        // Add the product list and pagination details to the model
        model.addAttribute("products", products.getContent());  // List of products on the current page
        model.addAttribute("search", search);  // Current search query
        model.addAttribute("totalPages", products.getTotalPages());  // Total number of pages
        model.addAttribute("currentPage", products.getNumber());  // Current page number
        model.addAttribute("pageSize", products.getSize());  // Page size
        model.addAttribute("hasNext", products.hasNext());  // If there is a next page
        model.addAttribute("hasPrevious", products.hasPrevious());  // If there is a previous page

        return "product/products"; // View path: "entity's name"/"view name" (Thymeleaf view)
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
    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        // Call service to perform soft delete
        productService.deleteProduct(id);

        // Redirect back to the products list after deletion
        return "redirect:/products";
    }
}
