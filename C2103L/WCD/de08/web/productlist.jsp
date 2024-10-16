<%@page import="java.util.List"%>
<%@page import="models.Category"%>
<%@page import="models.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <%
            Category category = (Category)request.getAttribute("category");
            List<Product> products = (List<Product>)request.getAttribute("products");
        %>
        <h2>Product List - <%= category.getName() %></h2>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% for (Product product : products) { %>
                    <tr>
                        <td><%= product.getId() %></td>
                        <td><%= product.getName() %></td>
                        <td><%= product.getPrice() %></td>
                        <td><%= product.getDescription() %></td>
                        <td>
                            <a href="ProductServlet?product_id=<%= product.getId() %>">Assign this product to another Category</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>

        <a href="CategoryServlet">Back to Categories</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
