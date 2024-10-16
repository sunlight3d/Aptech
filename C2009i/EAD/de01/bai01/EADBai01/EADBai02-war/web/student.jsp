
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.Student"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student list</h1>
        <table>
        <c:forEach items="${students}" var="student">
         <tr>
           <td>${student.id}</td>           
         </tr>
         <tr>
           <td>${student.fullName}</td>
           
         </tr>
         <tr>
           <td>${student.description}</td>           
         </tr>
        </c:forEach>
      </table>
         <a href="/StudentServlet">Insert Student</a>
    </body>
</html>
