<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="models.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Product</title>
</head>
<body>
    <h1>Update Product</h1>
    
    <%
        Product product = (Product) request.getAttribute("product");
        if (product != null) {
    %>
        <form action="${pageContext.request.contextPath}/products" method="post">
            <input type="hidden" name="id" value="<%= product.getId() %>">
            <input type="hidden" name="_method" value="update">
            
            <label for="productName">Tên sản phẩm:</label>
            <input type="text" name="productName" value="<%= product.getName() %>" required>
            <br><br>
            
            <label for="price">Giá:</label>
            <input type="number" step="0.01" id="price" name="price" value="<%= product.getPrice() %>" required>
            <br><br>
            
            <label for="quantity">Số lượng:</label>
            <input type="number" id="quantity" name="quantity" value="<%= product.getQuantity() %>" required>
            <br><br>
            
            <label for="description">Mô tả:</label>
            <textarea id="description" name="description"><%= product.getDescription() %></textarea>
            <br><br>
            
            <button type="submit">Save Changes</button>
        </form>
    <% 
        } else { 
    %>
        <p>Product not found.</p>
    <% 
        } 
    %>
</body>
</html>
