<%-- 
    Document   : employees
    Created on : Aug 12, 2021, 11:11:54 AM
    Author     : sunli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Employees</h1>
        <table style="width:50%">
            <c:forEach var="employee" items="${requestScope.employees}">
                
           </c:forEach>
            <tr>
              <th>Firstname</th>
              <th>Lastname</th> 
              <th>Age</th>
            </tr>
            <tr>
              <td>Jill</td>
              <td>Smith</td>
              <td>50</td>
            </tr>
            <tr>
              <td>Eve</td>
              <td>Jackson</td>
              <td>94</td>
            </tr>
            <tr>
              <td>John</td>
              <td>Doe</td>
              <td>80</td>
            </tr>
          </table>
    </body>
</html>
