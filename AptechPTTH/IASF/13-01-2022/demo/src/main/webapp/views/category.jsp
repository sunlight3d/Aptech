<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>This is an example</title>
</head>
<body>
    <h1>Categories List</h1>
    <table>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
          <th>Actions</th>
        </tr>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.getCategoryID()}</td>
                <td>${category.getCategoryName()}</td>
                <td>${category.getDescription()}</td>
                <td>
                    <a href="product?categoryId=${category.getCategoryID()}">Show Product</a>
                </td>
            </tr>
        </c:forEach>
      </table>
    
</body>
</html>