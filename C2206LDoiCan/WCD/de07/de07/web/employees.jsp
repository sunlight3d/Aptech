<%-- 
    Document   : employees
    Created on : Mar 24, 2024, 11:53:20 PM
    Author     : ChungTV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="models.Employee" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Information</title>
        <style>
           .styled-link {
                background: none;
                border: none;
                padding: 0;
                font: inherit;
                text-decoration: underline;
                cursor: pointer;
                color: blue;
            }
            .styled-link:hover {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <h2>Employee Information</h2>
            <table border="1">
                <thead>
                    <th>Employee No</th>
                    <th>Name</th>
                    <th>Place of Work</th>
                    <th>Phone No</th>
                    <th>Delete</th>
                </thead>
                <tbody>
                    <% List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                       if (employees != null) {
                           for (Employee employee : employees) { %>
                               <tr>
                                   <td><%= employee.getEmployeeNo() %></td>
                                   <td><%= employee.getEmployeeName() %></td>
                                   <td><%= employee.getPlaceOfWork() %></td>
                                   <td><%= employee.getPhoneNo() %></td>
                                   <td>
                                       <form action="EmployeeServlet" method="post">
                                           <input type="hidden" name="_method" value="DELETE">
                                           <input class="styled-link" type="submit" id="employeeNo" name="employeeNo" value="<%= employee.getEmployeeNo() %>">
                                        </form>
                                   </td>
                               </tr>
                    <%    }
                       } %>
                </tbody>
            </table>
            <a href="EmployeeServlet?type=addNew">
                Add New
            </a>
    </body>
</html>
