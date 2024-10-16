CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL
);

INSERT INTO products (name, price, quantity) VALUES
    ('Macbook Air 13 inch', 1299.99, 50),
    ('iPhone 15', 799.99, 100),
    ('Samsung Galaxy S22', 899.99, 75),
    ('Sony Bravia 55" 4K TV', 1499.99, 30),
    ('Dell XPS 15 Laptop', 1599.99, 45),
    ('PlayStation 5', 499.99, 60),
    ('Canon EOS R5 Camera', 3499.99, 20),
    ('Bose QuietComfort 45 Headphones', 299.99, 80),
    ('Google Pixel 7', 699.99, 40),
    ('LG OLED 65" 4K TV', 2499.99, 25),
    ('Apple Watch Series 7', 299.99, 55),
    ('Nintendo Switch OLED', 399.99, 70),
    ('Microsoft Surface Pro 8', 1199.99, 35),
    ('Sony WH-1000XM4 Headphones', 279.99, 90),
    ('Samsung Galaxy Tab S7', 649.99, 15),
    ('GoPro Hero 10', 499.99, 10),
    ('Sony PS5 Game Console', 699.99, 5),
    ('DJI Air 2S Drone', 999.99, 8),
    ('Sony Alpha A7 IV Camera', 2499.99, 12),
    ('Samsung Galaxy Watch 4', 299.99, 18);


