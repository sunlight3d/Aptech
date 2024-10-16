<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>This is an example</title>
</head>
<body>
    <h1>Product List</h1>
    <table>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Price</th>
          <th>Description</th>
          <th>Action</th>
        </tr>
        <c:forEach var="product" items="${productLists}">
            <tr>
                <td>${product.getProductID()}</td>
                <td>${product.getProductName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getDescription()}</td>
                <td><a>Add this product to other category</a></td>
                <td>
                    <!-- <a href="assign-servlet?productId=${product.getPId()}&categoryId=${product.getId()}">Assign
                        Assign this product to other category</a> -->
                </td>
            </tr>
        </c:forEach>
      </table>    
</body>
</html>

