<%@page import="java.util.*"%>
<%@page import="models.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Assign Product</title>
</head>
<body>
    <% Product product = (Product) request.getAttribute("product"); %>
    <h1>Do you really want to assign <%= product.getName() %> to another category?</h1>
    
    <form action="ProductServlet" method="POST">
        <label for="category">Select Category:</label>
        <select name="category" id="category">
            <% List<Category> categories = (List<Category>) request.getAttribute("categories");
               if (categories != null) {
                   for (Category category : categories) { %>
                       <option name="categoryId" value="<%= category.getId() %>"><%= category.getName() %></option>
            <%    }
               } %>
        </select>
        
        <input type="hidden" name="productId" value="<%= product.getId() %>">
        
        <button type="submit">Update</button>
    </form>
</body>
</html>