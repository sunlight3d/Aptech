CREATE DATABASE ShopApp;

CREATE TABLE `Role` (
  `id` int PRIMARY KEY,
  `name` varchar(20) NOT NULL
);

CREATE TABLE `User` (
  `id` int PRIMARY KEY,
  `fullname` varchar(100),
  `phone_number` varchar(20) NOT NULL,
  `address` varchar(200),
  `password` varchar(32) NOT NULL,
  `role_id` int,
  `created_at` datetime,
  `updated_at` datetime,
  `deleted` int
);

CREATE TABLE `Category` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) NOT NULL UNIQUE
);

CREATE TABLE `Product` (
  `id` int PRIMARY KEY,  
  `category_id` int,
  `title` varchar(350),
  `price` int,
  `discount` int,
  `thumbnail` varchar(500) NOT NULL,
  `description` longtext DEFAULT '',
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `Gallery` (
  `id` int PRIMARY KEY,
  `product_id` int,
  `thumbnail` varchar(500) NOT NULL
);

CREATE TABLE `Feedback` (
  `id` int PRIMARY KEY,
  `firstname` varchar(30),
  `lastname` varchar(30),
  `email` varchar(150) NOT NULL,,
  `phone_number` varchar(20),
  `subject_name` varchar(200),
  `note` varchar(500)
);

CREATE TABLE `Order` (
  `id` int PRIMARY KEY,
  `user_id` int,
  `fullname` varchar(100),
  `email` varchar(150) NOT NULL,
  `phone_number` varchar(20),
  `address` varchar(200) NOT NULL,
  `note` varchar(200) DEFAULT '',
  `order_date` datetime DEFAULT CURRENT_TIMESTAMP,  
  `status` ENUM('pending', 'processing', 'completed', 'cancelled') NOT NULL DEFAULT 'pending',
  `total_money` int DEFAULT 0
);

CREATE TABLE `OrderDetail` (
  `id` int PRIMARY KEY,
  `order_id` int,
  `product_id` int,
  `price` int NOT NULL,
  `number_of_products` int NOT NULL CHECK (number_of_products > 0),
  `total_money` int NOT NULL
);

ALTER TABLE `User` ADD FOREIGN KEY (`role_id`) REFERENCES `Role` (`id`);

ALTER TABLE `Product` ADD FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`);

ALTER TABLE `OrderDetail` ADD FOREIGN KEY (`order_id`) REFERENCES `Order` (`id`);

ALTER TABLE `OrderDetail` ADD FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`);

ALTER TABLE `Product` ADD FOREIGN KEY (`id`) REFERENCES `Gallery` (`product_id`);

ALTER TABLE `Order` ADD FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);