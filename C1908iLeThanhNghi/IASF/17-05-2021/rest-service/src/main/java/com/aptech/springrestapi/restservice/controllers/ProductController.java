package com.aptech.springrestapi.restservice.controllers;

import com.aptech.springrestapi.restservice.components.ScheduledTasks;
import com.aptech.springrestapi.restservice.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Hashtable;

@RestController//phuc vu cho nhan request
@RequestMapping("/products")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    //routing
    @GetMapping("/getAllProducts")
    //cac request POST/PUT...
    public Hashtable<String, Object> getAllProducts(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "query", defaultValue = "") String query
    ) {
        Hashtable<String, Object> dictResponse = new Hashtable<>();
        dictResponse.put("code", 200);
        dictResponse.put("message", "Query successful");
        ArrayList<Product> fakedProducts = new ArrayList<>();
        fakedProducts.add(new Product(1, "iphone 5", 2005,"This is an iphone, 5"));
        fakedProducts.add(new Product(2, "iphone 6", 2006,"This is an iphone, 6"));
        fakedProducts.add(new Product(3, "iphone 7", 2007,"This is an iphone, 7"));
        dictResponse.put("data", fakedProducts);
        return  dictResponse;
    }
    @PostMapping("/insertProduct")
    public Hashtable<String, Object> insertProduct(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "description", defaultValue="") String description
            )
    {
        Hashtable<String, Object> dictResponse = new Hashtable<>();
        dictResponse.put("code", 200);
        dictResponse.put("message", "Insert successful");
        dictResponse.put("data", new Product(2, "iphone 6", 2006,"This is an iphone, 6"));
        return  dictResponse;
    }
    @PutMapping("/updateProduct")
    public Hashtable<String, Object> updateProduct(
        @RequestBody Hashtable<String, Object> params
//            @RequestParam(value = "id", defaultValue = "0") Integer id,
//            @RequestParam(value = "name", defaultValue = "") String name,
//            @RequestParam(value = "description", defaultValue="") String description
    )
    {
        log.info("id = {}, name = {}, description = {}", params.get("id"), params.get("name"), params.get("description"));
        Hashtable<String, Object> dictResponse = new Hashtable<>();
        dictResponse.put("code", 200);
        dictResponse.put("message", "Update successful");
        dictResponse.put("data", new Product(2, "iphone 6", 2006,"This is an iphone, 6"));
        return  dictResponse;
    }
    @DeleteMapping("/deleteProduct")
    public Hashtable<String, Object> deleteProduct(
            @RequestParam(value = "id", defaultValue = "0") Integer id
    ){
        log.info("id = {}", id);
        Hashtable<String, Object> dictResponse = new Hashtable<>();
        dictResponse.put("code", 200);
        dictResponse.put("message", String.format("Delete product %d successful", id));
        dictResponse.put("data", new Product(2, "iphone 6", 2006,"This is an iphone, 6"));
        return  dictResponse;
    }
    //viet api upload profile/user
}
