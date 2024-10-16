
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.Book"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book list</h1>
        <table>
        <c:forEach items="${books}" var="book">
         <tr>
           <td>${post.id}</td>           
         </tr>
         <tr>
           <td>${post.bookName}</td>
           
         </tr>
         <tr>
           <td>${post.description}</td>           
         </tr>
        </c:forEach>
      </table>
    </body>
</html>
