<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,database.*,models.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1>Product Manager</h1>        
            <form action="productadd.jsp" method="post">
                <table>
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="productId"></td>
                    </tr>
                    <tr>
                        <td>Product Name</td>
                        <td><input type="text" name="productName"></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" name="price"></td>
                    </tr>
                    <tr>
                        <td>Quantity</td>
                        <td><input type="text" name="quantity"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="submit" value="Add Product"></td>
                        <td></td>
                    </tr>
                </table>
            </form>
            <%
            if(request.getParameter("submit") != null) {
                Integer productId = Integer.parseInt(request.getParameter("productId"));
                String productName = request.getParameter("productName");
                Float price = Float.parseFloat(request.getParameter("price"));
                Integer quantity = Integer.parseInt(request.getParameter("quantity"));
                Database db = Database.getInstance();
                db.insertProduct(new Product(productId, productName, price, quantity)); 
            }        
        %>
        </center>
        
    </body>
</html>
