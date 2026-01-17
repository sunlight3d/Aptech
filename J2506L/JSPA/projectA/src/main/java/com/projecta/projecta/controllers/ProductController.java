package com.projecta.projecta.controllers;

import com.projecta.projecta.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/products")

public class ProductController {
    //Client gui request => server tra ve text
    //http://localhost:8086/products/10
    @GetMapping("{id}")
    public String getProductWithId(@PathVariable Integer id) {
        return "chao ban, toi chua lam gi ca";
    }

    @GetMapping("show_all")
    //http://localhost:8086/products/show_all?page=1&size=10
    public ArrayList getAllProducts(
            @RequestParam int page,
            @RequestParam int size
    ) {
        //tra ve 1 array co 2 san pham
        ArrayList products = new ArrayList<>();
        products.add(Product.builder()
                .name("iphone 16")
                .price(123.0)
                .id(1)
                .build());
        products.add(new Product(2,"laptop xiaomi", 236));
        return products;
    }
    @PostMapping("")
    public String insert() {
        return "insert product";
    }
    //Client gui request => server tra ve danh sach san pham
}
