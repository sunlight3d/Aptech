use c2209g;
create table products(
	id int auto_increment primary key,
	name varchar(100) not null,
	price decimal(10, 2) default 0,
	quantity int check(quantity >= 0)
);

INSERT INTO products (name, price, quantity) VALUES
('Laptop', 999.99, 50),
('Smartphone', 699.99, 150),
('Tablet', 499.99, 75),
('Smartwatch', 199.99, 120),
('Headphones', 89.99, 200),
('Keyboard', 49.99, 180),
('Mouse', 29.99, 250),
('Monitor', 149.99, 80),
('Printer', 99.99, 60),
('Router', 59.99, 100),
('External Hard Drive', 79.99, 110),
('USB Flash Drive', 19.99, 300),
('Webcam', 39.99, 140),
('Speakers', 59.99, 90),
('Microphone', 69.99, 50),
('Gaming Chair', 199.99, 40),
('Desk Lamp', 24.99, 130),
('Surge Protector', 19.99, 220),
('Laptop Stand', 29.99, 100),
('Docking Station', 89.99, 70);

-- Verify the inserted data
SELECT * FROM products;