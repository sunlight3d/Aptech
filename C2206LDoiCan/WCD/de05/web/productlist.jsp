<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Product Manager</h1>
        <form method="GET" action="ProductServlet">                    
        <div>
            <span>Search</span><input type="text" name="searchText" />
            <span>
                <input type="submit" value="Search"> 
            </span>
        </div>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.quantity}</td>
                        <td>
                            <form action="ProductServlet" method="POST">
                                <input type="hidden" name="action" value="delete"> <!-- Add action parameter -->
                                <input type="hidden" name="productId" value="${product.id}">
                                <button type="submit" onclick="return confirm('Are you sure you want to delete ${product.name}?')">Delete</button>
                            </form>
                        </td>

                        
                    </tr>
                </c:forEach>
            </table>                    
        </form>
        <a href="productadd.jsp">Add New</a>
    </center>
        
    </body>
</html>
