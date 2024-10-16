<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="models.Category"%>
<%@page import="models.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Category List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% List<Category> categories = (List<Category>) request.getAttribute("categories");
               if (categories != null) {
                   for (Category category : categories) { %>
                       <tr>
                           <td><%= category.getId() %></td>
                           <td><%= category.getName() %></td>
                           <td><%= category.getDescription() %></td>
                           <td>
                               <a href="ProductServlet?type=findAll&category_id=<%= category.getId() %>">
                                   Show Products
                               </a>
                           </td>
                       </tr>
            <%    }
               } %>
        </tbody>
    </table>
</body>
</html>