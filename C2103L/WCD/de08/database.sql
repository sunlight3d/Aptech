USE c2103l;
CREATE TABLE Categories (
    id varchar(10) PRIMARY KEY,
    name varchar(200),
    description varchar(100)
);

CREATE TABLE Products (
    id varchar(10) PRIMARY KEY,
    name varchar(200),
    price FLOAT,
    description varchar(100),
    category_id varchar(10),
    FOREIGN KEY (category_id) REFERENCES Categories(id)
);

-- Thêm dữ liệu vào bảng Categories
INSERT INTO Categories (id, name, description)
VALUES ('C1', 'Category 1', 'Description 1'),
       ('C2', 'Category 2', 'Description 2'),
       ('C3', 'Category 3', 'Description 3');

-- Thêm dữ liệu vào bảng Products
INSERT INTO Products (id, name, price, description, category_id)
VALUES ('P1', 'Product 1', 10.99, 'Description 1', 'C1'),
       ('P2', 'Product 2', 19.99, 'Description 2', 'C1'),
       ('P3', 'Product 3', 7.99, 'Description 3', 'C2');


