CREATE DATABASE c2206l;
USE c2206l;
CREATE TABLE employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  age INT NOT NULL,
  address VARCHAR(255),
  salary DECIMAL(10, 2) NOT NULL
);
INSERT INTO employees (name, age, address, salary) VALUES
  ('John Doe', 30, '123 Main St', 50000.00),
  ('Alice Smith', 25, '456 Elm St', 60000.00),
  ('Bob Johnson', 35, '789 Oak St', 55000.00),
  ('Sarah Brown', 28, '101 Pine St', 65000.00),
  ('Michael Davis', 32, '202 Maple St', 70000.00),
  ('Emily Wilson', 29, '303 Cedar St', 52000.00),
  ('David Lee', 34, '404 Birch St', 48000.00),
  ('Jennifer Hall', 27, '505 Redwood St', 75000.00),
  ('Daniel Miller', 31, '606 Spruce St', 58000.00),
  ('Lisa White', 26, '707 Sequoia St', 62000.00),
  ('Matthew Moore', 33, '808 Red St', 68000.00),
  ('Olivia Martin', 28, '909 Blue St', 59000.00),
  ('James Clark', 35, '1010 Green St', 72000.00),
  ('Sophia Anderson', 30, '1111 Yellow St', 53000.00),
  ('William Rodriguez', 29, '1212 Orange St', 64000.00),
  ('Ava Taylor', 27, '1313 Violet St', 57000.00),
  ('Joseph Hernandez', 32, '1414 Indigo St', 71000.00),
  ('Charlotte Wilson', 31, '1515 Lavender St', 66000.00),
  ('Benjamin Gonzalez', 28, '1616 Maroon St', 54000.00),
  ('Mia Perez', 26, '1717 Teal St', 59000.00);

