package org.example;


import org.example.models.Product;

public class Main {
    public static void main(String[] args) {

        Product productA = new Product(1L, "iphone 4", 13.3, 100,"Apple", 3L);
        Product  productB = Product.builder()
                .price(123.4)
                .name("xyz abc")
                .count(123)
                .brandName("Aptech")
                .categoryId(2L)
                .build();
        System.out.println(productA.getName());
        System.out.println("haha");
        System.out.println(productB);



    }
    /*
    How to connect from Java Application to MySQL:
    - JDBC(Java Database Connectivity)
    - JPA(Java Persistence API),see my udemy course(api, backend, frontend,...)
    * */
}
/*
CREATE DATABASE testdb;
use testdb;
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) CHECK(price > 0),
    count INT DEFAULT 1,
    brand_name VARCHAR(20)
);

CREATE TABLE categories(
    id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL UNIQUE,
    description TEXT
);

ALTER TABLE products
ADD COLUMN category_id INT,
ADD CONSTRAINT fk_category_id
FOREIGN KEY (category_id)
REFERENCES categories(id);

ALTER TABLE products
ADD CONSTRAINT unique_product_name UNIQUE (name);


-- Inserting a new category
INSERT INTO categories (category_name, description) VALUES ('Clothing', 'Various clothing items');
-- Inserting another category
INSERT INTO categories (category_name, description) VALUES ('Home & Garden', 'Products for home and gardening');
-- Inserting one more category
--INSERT INTO categories (category_name, description) VALUES ('Sports & Outdoors', 'Items related to sports and outdoor activities');
INSERT INTO categories (category_name, description) VALUES ('Electronics', 'Devices and gadgets powered by technology');
INSERT INTO categories (category_name, description) VALUES ('Books', 'Various genres of books for reading enthusiasts');
INSERT INTO categories (category_name, description) VALUES ('Toys & Games', 'Entertainment items for children and adults');
INSERT INTO categories (category_name, description) VALUES ('Health & Wellness', 'Products for maintaining a healthy lifestyle');
INSERT INTO categories (category_name, description) VALUES ('Furniture', 'Items for furnishing homes and offices');

-- Inserting fake data into the products table with category_id
INSERT INTO products (name, price, count, brand_name, category_id)
VALUES ('T-Shirt', 19.99, 10, 'Nike', 1),
       ('LED TV', 599.99, 5, 'Samsung', 3),
       ('Gardening Tools Set', 39.99, 20, 'GreenThumb', 2),
       ('Mystery Novel', 9.99, 15, 'Penguin Books', 4),
       ('Board Game', 29.99, 8, 'Hasbro', 5),
       ('Protein Shake', 24.99, 50, 'Optimum Nutrition', 6),
       ('Office Chair', 149.99, 3, 'Herman Miller', 7);

* */