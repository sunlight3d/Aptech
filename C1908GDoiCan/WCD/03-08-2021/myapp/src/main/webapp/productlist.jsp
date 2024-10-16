<%-- 
    Document   : productlist
    Created on : Aug 5, 2021, 10:47:27 AM
    Author     : sunli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        table, th, td {
          border: 1px solid black;
        }
        </style>
    </head>
    <body>
        <h2>Product List</h2>
        <table style="width:100%">
          <tr>
            <th>ID</th>
            <th>Name</th> 
            <th>Price</th>
            <th>Description</th>
            <th>Actions</th>             
          </tr>
          <tr>
            <td>P01</td>
            <td>Chau</td>
            <td>$123</td>
            <td>fndjhfjdh</td>
            <td><a href="assign.jsp">Assign this product to other Category</a></td>
          </tr>          
        </table>
        <a href="category.jsp">Back to category</a>
    </body>
</html>
