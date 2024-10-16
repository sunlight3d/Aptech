USE c2108g3;
-- Create the 'categories' table
CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

-- Create the 'products' table with a foreign key reference to 'categories'
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
-- Insert 10 records into the 'categories' table
INSERT INTO categories (name, description)
VALUES
    ('Category 1', 'Description 1'),
    ('Category 2', 'Description 2'),
    ('Category 3', 'Description 3'),
    ('Category 4', 'Description 4'),
    ('Category 5', 'Description 5'),
    ('Category 6', 'Description 6'),
    ('Category 7', 'Description 7'),
    ('Category 8', 'Description 8'),
    ('Category 9', 'Description 9'),
    ('Category 10', 'Description 10');

-- Insert 20 records into the 'products' table, associating them with categories
INSERT INTO products (name, description, price, category_id)
VALUES
    ('Product 1', 'Description 1', 19.99, 1),
    ('Product 2', 'Description 2', 29.99, 1),
    ('Product 3', 'Description 3', 9.99, 2),
    ('Product 4', 'Description 4', 14.99, 2),
    ('Product 5', 'Description 5', 24.99, 3),
    ('Product 6', 'Description 6', 12.99, 3),
    ('Product 7', 'Description 7', 39.99, 4),
    ('Product 8', 'Description 8', 8.99, 4),
    ('Product 9', 'Description 9', 17.99, 5),
    ('Product 10', 'Description 10', 7.99, 5),
    ('Product 11', 'Description 11', 32.99, 6),
    ('Product 12', 'Description 12', 15.99, 6),
    ('Product 13', 'Description 13', 22.99, 7),
    ('Product 14', 'Description 14', 11.99, 7),
    ('Product 15', 'Description 15', 18.99, 8),
    ('Product 16', 'Description 16', 13.99, 8),
    ('Product 17', 'Description 17', 27.99, 9),
    ('Product 18', 'Description 18', 10.99, 9),
    ('Product 19', 'Description 19', 16.99, 10),
    ('Product 20', 'Description 20', 6.99, 10);


