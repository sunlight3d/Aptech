<%@ page import="java.util.List" %>
<%@ page import="entities.Product" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Product List</h1>
    <form action="ProductServlet" method="GET">
        <input type="text" name="searchText" placeholder="Search products...">
        <button type="submit">Search</button>
    </form>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Action</th>
        </tr>
        <% 
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products != null && !products.isEmpty()) {
                for (Product product : products) {
        %>
        <tr>
            <td><%= product.getId() %></td>
            <td><%= product.getName() %></td>
            <td><%= product.getPrice() %></td>
            <td><%= product.getQuantity() %></td>
            <td>
                <a href="ProductServlet?action=edit&id=<%= product.getId() %>">Edit</a>
                <a href="ProductServlet?action=delete&id=<%= product.getId() %>">Delete</a>
            </td>
        </tr>
        <% 
                }
            } else {
        %>
        <tr>
            <td colspan="5">No products found</td>
        </tr>
        <% 
            }
        %>
    </table>
    <br>
    <% 
        Integer currentPage = (Integer) request.getAttribute("currentPage");
        Integer totalPages = (Integer) request.getAttribute("totalPages");
        if (totalPages != null) {
            for (int i = 1; i <= totalPages; i++) {
                if (i == currentPage) {
    %>
    <b><%= i %></b>
    <% 
                } else {
    %>
    <a href="ProductServlet?page=<%= i %>&searchText=<%= request.getParameter("searchText") %>"><%= i %></a>
    <% 
                }
            }
        }
    %>
    <br>
    <a href="add_product.jsp">Add New Product</a>
</body>
</html>
