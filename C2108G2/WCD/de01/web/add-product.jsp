<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Add New Product</h1>
    <%
        Map<String, String> errors = (Map<String, String>)request.getAttribute("errors");
        if(errors == null) {
            errors = new HashMap<String, String>();
        }
    %>
    <form action="ProductServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <span class="error">
            <% if (errors.containsKey("nameError")) {
                out.println(errors.get("nameError"));
            } %>
        </span><br>
        
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required>
        <span class="error">
            <% if (errors.containsKey("priceError")) {
                out.println(errors.get("priceError"));
            } %>                        
        </span><br>
        
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required>
        <span class="error">
            <% if (errors.containsKey("quantityError")) {
                out.println(errors.get("quantityError"));
            } %>                                    
        </span><br>
        
        <input type="submit" value="Add">
    </form>
    <br>
    <a href="ProductServlet?action=getAll">Back to Product List</a>
</body>
</html>
