CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL
);
INSERT INTO products (name, price, quantity)
VALUES
    ('Awesome Smartphone', 599.99, 100),
    ('Premium Laptop', 1299.99, 50),
    ('High-Performance Gaming PC', 1999.99, 25),
    ('Ultra HD Smart TV', 799.99, 75),
    ('Designer Smartwatch', 249.99, 150),
    ('Wireless Noise-Canceling Headphones', 149.99, 200),
    ('Smart Home Starter Kit', 399.99, 30),
    ('Professional DSLR Camera', 1299.99, 40),
    ('Stylish Bluetooth Speaker', 69.99, 120),
    ('Powerful Desktop Monitor', 499.99, 60),
    ('Gourmet Coffee Machine', 79.99, 80),
    ('Fitness Tracker', 89.99, 70),
    ('High-Speed Wi-Fi Router', 129.99, 55),
    ('Home Security Camera System', 299.99, 35),
    ('Digital Art Drawing Tablet', 399.99, 20),
    ('Smart Refrigerator', 1499.99, 10),
    ('Electric Scooter', 299.99, 45),
    ('Convertible Car Seat', 199.99, 65),
    ('Outdoor Camping Tent', 149.99, 90),
    ('Deluxe Massage Chair', 999.99, 15);


