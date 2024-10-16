<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Categories</title>
</head>
<body>
    <h1>List of Categories</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <% List<models.Category> categories = (List<models.Category>) request.getAttribute("categories"); %>
            <% for (models.Category category : categories) { %>
                <tr>
                    <td><%= category.getId() %></td>
                    <td><%= category.getName() %></td>
                    <td><%= category.getDescription() %></td>
                    <td>
                        <a href="<%= request.getContextPath() %>/ProductServlet?action=showProducts&categoryId=<%= category.getId() %>">
                            Show Products
                        </a>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
