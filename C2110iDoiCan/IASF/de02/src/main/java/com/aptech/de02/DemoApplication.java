package com.aptech.de02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
/*
CREATE DATABASE IF NOT EXISTS
c2110i DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE c2110i;

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `category_id` varchar(10) NOT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `categories` (`category_id`, `category_name`, `description`) VALUES
('C0101', 'Beverages', 'Soft drinks, coffees, teas, beers, and ales'),
('C0102', 'Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings'),
('C0103', 'Confections', 'Desserts, candies, and sweet breads'),
('C0104', 'Dairy products', 'Cheeses'),
('C0105', 'Grains_Cereals', 'Breads, crackers, pasta, and cereal'),
('C0106', 'Meat_Poultry', 'Prepared meats'),
('C0107', 'Produce', 'Dried fruit and bean curd'),
('C0108', 'Seafood', 'Seaweed and fish');

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `product_id` varchar(10) NOT NULL,
  `category_id` varchar(10) DEFAULT NULL,
  `product_name` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `products` (`product_id`, `category_id`, `product_name`, `price`, `description`) VALUES
('P0101', 'C0101', 'Chai', 18, 'Good product'),
('P01010', 'C0104', 'Ikura', 31, 'Good'),
('P01011', 'C0105', 'Queso Cabrales', 21, 'Good'),
('P01012', 'C0105', 'Queso Manchego La Pastora', 38, 'Good'),
('P0102', 'C0101', 'Chang', 19, 'best sell product'),
('P0103', 'C0101', 'Aniseed Syrup', 10, 'new produced'),
('P0104', 'C0102', 'Chef Anton\'s Cajun Seasoning', 22, 'popular product'),
('P0105', 'C0102', 'Chef Anton\'s Gumbo Mix', 21, 'Good For life'),
('P0106', 'C0103', 'Grandma\'s Boysenberry Spread', 25, 'Good'),
('P0107', 'C0103', 'Uncle Bob\'s Organic Dried Pears', 30, 'Good'),
('P0108', 'C0103', 'Northwoods Cranberry Sauce', 40, 'Good'),
('P0109', 'C0104', 'Mishi Kobe Niku', 97, 'Good');

ALTER TABLE `categories` ADD PRIMARY KEY (`category_id`);

ALTER TABLE `products` ADD PRIMARY KEY (`product_id`);
* */