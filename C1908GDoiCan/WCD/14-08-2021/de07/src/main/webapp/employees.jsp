<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table, th, td {
          border: 1px solid black;
        }
    </style>
    <body>
    <center>
        <h1>Employee Information</h1>
        <table style="width:50%">
            <tr>
              <th>Employee No</th>
              <th>Name</th> 
              <th>Place of Work</th>
              <th>Phone number</th>
              <th>Delete</th>
            </tr>
            <tr>
              <td>E123</td>
              <td>Nguyen Van A</td>
              <td>Hai Duong</td>
              <td>123454545</td>
              <td><a href="/de07/EmployeeServlet?EmployeeNo=123">E123</a></td>
            </tr>            
          </table>
        <a href="/de07/addEmployee.jsp">Add New</a>
    </center>
    </body>
</html>
