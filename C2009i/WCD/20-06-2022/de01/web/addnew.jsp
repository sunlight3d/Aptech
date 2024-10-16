<%-- 
    Document   : addnew
    Created on : Jun 22, 2022, 2:04:09 PM
    Author     : w11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Product Manager</h1>
        <form action="ProductServlet" method="POST">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id"></td>                    
                </tr>
                <tr>
                    <td>productName</td>
                    <td><input type="text" name="productName"></td>                    
                </tr>
                <tr>
                    <td>price</td>
                    <td><input type="text" name="price"></td>                    
                </tr>
                <tr>
                    <td>quantity</td>
                    <td><input type="text" name="quantity"></td>                    
                </tr>
                <tr>
                    <td><input type="submit" value="Insert"></td>
                    <td></td>                    
                </tr>                
            </table>
        </form>
    </body>
</html>
