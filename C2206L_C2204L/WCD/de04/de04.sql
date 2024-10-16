CREATE DATABASE de04;
USE de04;
CREATE TABLE products(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL DEFAULT '' UNIQUE,
	price DECIMAL(10, 2) DEFAULT 0,
	url VARCHAR(255) DEFAULT ''
);

INSERT INTO products (name, price, url)
VALUES
('iPhone X', 999.99, ''),
('iPhone 11', 1099.99, 'https://shopdidong.vn/profiles/shopdidongvn/uploads/attach/1632215311_xss.jpg'),
('iPad Pro', 799.99, 'https://example.com/ipad-pro'),
('iPad Air', 599.99, 'https://example.com/ipad-air'),
('Samsung Galaxy S21', 899.99, 'https://example.com/samsung-galaxy-s21'),
('Samsung Galaxy Tab S7', 699.99, 'https://example.com/samsung-galaxy-tab-s7'),
('Laptop Dell XPS 13', 1399.99, 'https://example.com/dell-xps-13'),
('Laptop HP Spectre x360', 1299.99, 'https://example.com/hp-spectre-x360'),
('T-shirt', 19.99, 'https://example.com/t-shirt'),
('Jeans', 49.99, 'https://example.com/jeans'),
('Smart TV', 799.99, 'https://example.com/smart-tv'),
('Bluetooth Speaker', 59.99, 'https://example.com/bluetooth-speaker'),
('Digital Camera', 399.99, 'https://example.com/digital-camera'),
('Headphones', 99.99, 'https://example.com/headphones'),
('Microwave Oven', 199.99, 'https://example.com/microwave-oven'),
('Refrigerator', 1499.99, 'https://example.com/refrigerator'),
('Washing Machine', 899.99, 'https://example.com/washing-machine'),
('Dress', 79.99, 'https://example.com/dress'),
('Shoes', 69.99, 'https://example.com/shoes'),
('Handbag', 149.99, 'https://example.com/handbag');

UPDATE products SET url='https://shopdidong.vn/profiles/shopdidongvn/uploads/attach/1632215311_xss.jpg'
WHERE 1=1;