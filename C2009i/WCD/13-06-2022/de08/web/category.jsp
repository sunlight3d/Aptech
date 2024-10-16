<%-- 
    Document   : category
    Created on : Jun 13, 2022, 11:43:24 AM
    Author     : w11
--%>

<%@page import="java.util.List"%>
<%@page import="com.models.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    <center>
        <h1>Categories List</h1>        
        <hr style="width:50%" />
        <table style="width:50%">
            
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
            <%            
                List<Category> categories = (List<Category>)request.getAttribute("categories");            
                for(Category category: categories) {
                    out.print("<tr>");        
                    out.print("<td>"+category.getId()+"</td>");
                    out.print("<td>"+category.getName()+"</td>");
                    out.print("<td>"+category.getDescription()+"</td>");
                    out.print("<td><a href='ProductServlet'>Show Products</a></td>");
                    out.print("</tr>");                    
                }
            %>            
        </table>        
        <hr style="width:50%" />
    </center>        
    </body>
</html>
