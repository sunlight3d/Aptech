<%@page import="java.util.List"%>
<%@page import="models.Product"%>
<%@page import="models.Product"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% List<Product> products = (List<Product>) request.getAttribute("products");
               if (products != null) {
                   for (Product product : products) { %>
                       <tr>
                           <td><%= product.getId() %></td>
                           <td><%= product.getName() %></td>
                           <td><%= product.getPrice() %></td> 
                           <td><%= product.getDescription() %></td>
                           <td>
                               <a href="ProductServlet?type=assign&product_id=<%= product.getId() %>">
                                   Assign this product to another category
                               </a>
                           </td>
                       </tr>
            <%    }
               } %>
        </tbody>
    </table>
</body>
</html>