<!--
-- Tạo database c2103l nếu chưa tồn tại
CREATE DATABASE IF NOT EXISTS c2103l;

-- Sử dụng database c2103l
USE c2103l;

-- Tạo bảng Product
CREATE TABLE Product (
  id INT PRIMARY KEY AUTO_INCREMENT,
  product_name VARCHAR(255) NOT NULL CHECK (LENGTH(product_name) >= 4),
  price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
  quantity INT NOT NULL CHECK (quantity > 0)
);
INSERT INTO Product (product_name, price, quantity)
VALUES
    ('Product 1', 10.99, 100),
    ('Product 2', 20.99, 200),
    ('Product 3', 30.99, 300),
    ('Product 4', 40.99, 400),
    ('Product 5', 50.99, 500),
    ('Product 6', 60.99, 600),
    ('Product 7', 70.99, 700),
    ('Product 8', 80.99, 800),
    ('Product 9', 90.99, 900),
    ('Product 10', 100.99, 1000);

SELECT * FROM Product;
-->
<%@page import="models.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page import="java.util.List" %>
<%@ page import="database.ProductDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <%
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProduct();
    %>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Product product : products) {
            %>
            <tr>
                <td><%= product.getId()%></td>
                <td><%= product.getProductName()%></td>
                <td><%= product.getPrice()%></td>
                <td><%= product.getQuantity()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <form action="addnew.jsp" method="GET">
        <input type="submit" value="Add New">
    </form>
</body>
</html>
