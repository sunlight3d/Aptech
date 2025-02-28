<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.model.Company"%>
<%@page import="java.util.List"%>
<%
    List<Company> companies = (List<Company>) request.getAttribute("companies");
%>
<html>
<head>
    <title>Company List</title>
</head>
<body>
    <h2>Company List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Company Key</th>
            <th>Description</th>
            <th>Address</th>
            <th>Enabled</th>
        </tr>
        <% for (Company company : companies) { %>
        <tr>
            <td><%= company.getId() %></td>
            <td><%= company.getName() %></td>
            <td><%= company.getCompanyKey() %></td>
            <td><%= company.getDescription() %></td>
            <td><%= company.getAddress() %></td>
            <td><%= company.getEnabled() ? "Yes" : "No" %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
