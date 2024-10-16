package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @RequestMapping(value = "/getProductByCategoryID/{categoryID}", method = RequestMethod.GET)
    //http:localhost:8080/product/getProductByCategoryID/C0103
    public String getProductByCategoryID(ModelMap modelMap, @PathVariable String categoryID) {
        Iterable<Product> products = productRepository.findByCategoryID(categoryID);
        modelMap.addAttribute("products", products);
        return "productlist"; //productlist.jsp
    }
}
