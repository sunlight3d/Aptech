<%@page import="java.util.List"%>
<%@page import="entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Product List</h1>
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
            if (products != null) {
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
            }
            %>

    </table>
    <br>
    <a href="add_product.jsp">Add New Product</a>
    </body>
</html>
