<%-- 
    Document   : index
    Created on : Feb 11, 2022, 11:50:19 PM
    Author     : sunli
--%>

<%@page import="java.util.List"%>
<%@page import="ws.Employee"%>
<%@page import="ws.EmployeeWS"%>
<%@page import="ws.EmployeeWS_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
    table, th, td {
      border:1px solid black;
      padding: 10px;
      border-collapse: collapse;
    }
    </style>
    <body>
    <center>
        <h1>Employee information</h1>
        <table >
        <tr>
          <th>Employee No</th>
          <th>Name</th>
          <th>Place of Work</th>
          <th>Phone No</th>
          <th>Delete</th>
        </tr>
         <%
            //call service, like WCF trong C#
            EmployeeWS_Service service = new EmployeeWS_Service();
            EmployeeWS port = service.getEmployeeWSPort();
            List<Employee> employees = port.findAll();                        
            for(Employee employee: employees) {
                out.println("<tr>");
                out.println("<td>"+employee.getEmployeeNo()+"</td>");
                out.println("<td>"+employee.getEmployeeName()+"</td>");
                out.println("<td>"+employee.getPlaceOfWork()+"</td>");
                out.println("<td>"+employee.getPhoneNo()+"</td>");
                out.println("<td>"+employee.getEmployeeNo()+"</td>");
                out.println("</tr>");                
            }
        %>        
      </table>
      <a href="./addnew.jsp">Add New</a>
      
       
    </center>        
    </body>
</html>
