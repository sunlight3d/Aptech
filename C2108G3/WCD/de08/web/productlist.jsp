<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category List</title>
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
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>
                        <ul>
                            <a href="/ProductServlet?action='chooseCategory'&productId=${product.id}">
                                Assisn this product to other category
                            </a>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<a href='/CategoryServlet'>Back to category</a>                        
</body>
</html>
