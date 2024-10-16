<%@page import="java.util.List"%>
<%@page import="models.Category"%>
<%@page import="models.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Assign Product</title>
</head>
<body>
    <h2>Assign Product</h2>
    
    <%-- Lấy giá trị của product_name từ request --%>
    <% 
        Product product = (Product) request.getAttribute("product");
        String productName = product.getName();
        List<Category> categories = (List<Category>) request.getAttribute("categories");
    %>
    
    <p>Do you really want to assign the product "<%= productName %>" to a category?</p>
    
    <form action="ProductServlet" method="POST">
        <input type="hidden" name="action" value="assign">

        <label for="category">Select a Category:</label>
        <select name="categoryId" id="category">
            <% for (Category category : categories) { %>
                <option value="<%= category.getId() %>"><%= category.getName() %></option>
            <% } %>
        </select>

        <br>
        <br>

        <input type="hidden" name="productId" value="<%= request.getParameter("product_id") %>">
        <input type="submit" value="Assign">
    </form>

</body>
</html>
