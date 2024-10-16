<%-- 
    Document   : add_product
    Created on : Jul 31, 2024, 10:18:51 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert product</h1>
        <form action="ProductServlet" method="POST">
            <input type="hidden" name="action" value="add"> 
            <label for="name">Product's name:</label> <input type="text" name="name">    
            <br>
            <label for="price">Price:</label> <input type="text" name="price">         
            <br>
            <label for="quantity">Quantity:</label> <input type="text" name="quantity">         
            <br>
            <input type="submit" value="Add">
        </form>
    </body>
</html>
