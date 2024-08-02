<%@page import="entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit product</h1>
        <%
            Product product = request.getAttribute("product");
            if(product != null) {
            %>
            <form action="ProductServlet" method="POST">
            <input type="hidden" name="action" value="update"> 
            <input type="hidden" name="productId" value="<%= product.getId() %>"> 
            <label for="name">Product's name:</label> 
            <input type="text" name="name" value="<%= product.getName() %>">    
            <br>
            <label for="price">Price:</label> 
            <input type="text" name="price" value="<%= product.getPrice() %>">         
            <br>
            <label for="quantity">Quantity:</label> 
                <input type="text" name="quantity" value="<%= product.getQuantity() %>">         
            <br>
            <input type="submit" value="Save">
        </form>
        <%
                }
            %>
        %>
        
    </body>
</html>
