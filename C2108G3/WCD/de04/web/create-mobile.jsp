<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Mobile</title>
</head>
<body>
    <h1>Create Mobile</h1>

    <form action="MobileServlet" method="post">
        <label for="mobileName">Name:</label>
        <input type="text" id="mobileName" name="mobileName" required><br>

        <label for="warranty">Warranty:</label>
        <input type="text" id="warranty" name="warranty"><br>

        <label for="inOutStock">In Stock:</label>
        <input type="radio" id="inStock" name="inOutStock" value="1" checked>
        <label for="inStock">Yes</label>
        <input type="radio" id="outOfStock" name="inOutStock" value="0">
        <label for="outOfStock">No</label><br>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required><br>

        <label for="accessories">Accessories:</label>
        <textarea id="accessories" name="accessories" rows="4" cols="50"></textarea><br>

        <label for="imageSrc">Image URL:</label>
        <input type="text" id="imageSrc" name="imageSrc"><br>

        <input type="hidden" name="action" value="create">
        <input type="submit" value="Create">
    </form>

    <a href="list-mobiles.jsp">Back to list</a>
</body>
</html>
