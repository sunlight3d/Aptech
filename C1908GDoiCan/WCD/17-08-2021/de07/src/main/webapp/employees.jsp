<%@page import="java.util.List"%>
<%@page import="com.aptech.de07.jpa.Employee"%>
<%@page import="com.aptech.de07.session.EmployeeFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <%
            EmployeeFacade employeeFacade = new EmployeeFacade();
            List<Employee> employees = employeeFacade.getAllEmployees();
            request.setAttribute("employees", employees);
        %>
        <table style="width:50%">                        
            <tr>
              <th>Employee No</th>
              <th>Name</th> 
              <th>Place of Work</th>
              <th>Phone number</th>
              <th>Delete</th>
            </tr>
            <c:forEach var="employee" items="${requestScope.employees}">
                <tr>
                    <td>${employee.employeeNo}</td>
                    <td>${employee.employeeName}</td>
                    <td>${employee.placeOfWork}</td>
                    <td>${employee.phoneNo}</td>
                    <td><a href="/de07/EmployeeServlet?EmployeeNo=123">${employee.employeeNo}</a></td>
                </tr>            
            </c:forEach>
            
            
          </table>
        <a href="/de07/addEmployee.jsp">Add New</a>
    </center>
    </body>
</html>
