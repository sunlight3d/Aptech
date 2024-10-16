package com.aptech.learning;

import com.aptech.learning.models.Ceramic;
import com.aptech.learning.models.Food;
import com.aptech.learning.models.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProductManagement {
    private ArrayList<Product> products;
    public void addProduct(Product product) {
        if(!this.isDuplicate(product)) {
            products.add(product);
        }
    }
    private Boolean isDuplicate(Product product) {
        for(Product eachProduct: this.products) {
            if(eachProduct.getProductId().equals(product.getProductId())) {
                return true;
            }
        }
        return false;
    }
    public ProductManagement() throws ParseException {
        products.add(
            new Food(12,
                    "sushi",
                    10,
                    120.0,
                    new SimpleDateFormat("yyyy-MM-dd")
                    .parse("2021-02-25"),
                    new SimpleDateFormat("yyyy-MM-dd")
                    .parse("2021-02-27"),
                    "cong ty A")
        );
        products.add(
            new Ceramic(122,
                    "bat su",
                    12,
                    110.0,
                    "cong ty B",
                    new SimpleDateFormat("yyyy-MM-dd")
                    .parse("2021-02-27"))
//            Integer productId, String productName, Integer amount, Double unitPrice,
//                   String producer, Date inventoryDate
        );
        //them cac doi tuong
        //List <Product> co the chua cac doi tuong Food, Ceramic, Machine,...

    }
}
