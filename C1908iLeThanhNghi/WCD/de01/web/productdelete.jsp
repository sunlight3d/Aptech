<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,database.*,models.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete product</title>
    </head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
          }
        
    </style>
    <body>
                
        <%            
            Database db = Database.getInstance();               
            //out.println(db.sayHello());            
            if(request.getParameter("productId") != null) {
                try
                {
                    Integer productId = Integer.parseInt(request.getParameter("productId"));
                    db.deleteProduct(productId);                
                    out.println("<h1>Delete product successfully</h1>");
                } catch(Exception e) {
                    out.println("<h1>Delete product failed</h1>");
                }
                
            }
        %>            
    </table>        
    </center>
    </body>
</html>
