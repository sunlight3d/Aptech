<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,database.*,models.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
          }
        
    </style>
    <body>
        <h1>Product list</h1>
        
    <center>
        <div style="margin: 20px;">
            <span>Search</span>
            <input type="text" name="searchText" >
            <input type="submit" name="Search" value="Search">    
        </div>
    <table>
        <tr>            
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Delete</th>
        </tr>
        <%            
            Database db = Database.getInstance();               
            //out.println(db.sayHello());
            ArrayList<Product> products = db.getAllProducts();                        
            for(Product product: products) {
                out.print("<tr>");
                out.print("<td>"+product.getProductName()+"</td>");
                out.print("<td>"+product.getPrice()+"</td>");
                out.print("<td>"+product.getQuantity()+"</td>");                
                out.print("<td><a href='productdelete.jsp?productId="+product.getId()+"'>Delete</a></td> ");                        
                out.print("</tr>");
            }
            //response.sendRedirect("productadd.jsp");            
        %>            
    </table> 
    <div style="margin: 10px;">
        
    </div>
    <%
        out.print("<td><a href='productadd.jsp'>Add New</a></td> ");        
    %>    
    </center>
    </body>
</html>
