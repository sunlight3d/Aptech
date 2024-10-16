<%-- 
    Document   : add-product
    Created on : Sep 25, 2023, 10:12:10 AM
    Author     : hoangnd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    <form action="ProductServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required><br>

        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required><br>

        <input type="hidden" name="action" value="create">

        <input type="submit" value="Add">
        <input type="reset" value="Reset">
    </form>
    <a href="ProductServlet?action=list">Back to Product List</a>
</body>
</html>


