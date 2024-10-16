<%@page import="com.aptech.models.Category"%>
<%@page import="com.aptech.Database"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Category List</h1>
        <hr>
        <%                                 
            Database database = Database.GetInstance();            
            List<Category> categories = database.getCategories();
            request.setAttribute("categories", categories);   
            
        %>
        <table style="width:100%">
            <tr>
              <th>ID</th>
              <th>Name</th> 
              <th>Description</th>
              <th>Actions</th>
            </tr>            
            <c:forEach var ="item" items = "${requestScope.categories}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.description}</td>
                    <td><a href="productlist.jsp?categoryId=${item.id}">Show Products</a></td>
                </tr>            
            </c:forEach>
            
          </table>
          <hr>          
    </center>        
    </body>
</html>