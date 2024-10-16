<%-- 
    Document   : employees
    Created on : Sep 15, 2023, 11:04:26 AM
    Author     : hoangnd
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Employees</title>
    <script>
        function confirmDelete(employeeNo) {
            var result = confirm("Are you sure you want to delete Employee #" + employeeNo + "?");
            if (result) {
                window.location.href = "EmployeeServlet?action=delete&employeeNo=" + employeeNo;
            }
        }
    </script>
</head>
<body>
    <h1>List of Employees</h1>
    <table border="1">
        <tr>
            <th>Employee Number</th>
            <th>Employee Name</th>
            <th>Place of Work</th>
            <th>Phone Number</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.employeeNo}</td>
                <td>${employee.employeeName}</td>
                <td>${employee.placeOfWork}</td>
                <td>${employee.phoneNo}</td>
                <td><a href="javascript:void(0);" onclick="confirmDelete('${employee.employeeNo}')">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="add_employee.jsp">Add New</a>
</body>
</html>
