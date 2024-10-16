package com.de11.de11.controllers;
import com.de11.de11.models.Product;
import com.de11.de11.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String listProducts(
            @RequestParam(value = "search", required = false, defaultValue = "") String searchTerm,
            Pageable pageable,
            Model model
    ) {
        Page<Product> page = productService.searchProducts(searchTerm, pageable);
        model.addAttribute("page", page);
        return "product/index";  // Name of the Thymeleaf template
    }
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("success",
                "Product deleted successfully!");
        return "redirect:/index";
    }
}
