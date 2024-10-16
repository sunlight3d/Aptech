<%@page import="java.util.List"%>
<%@page import="models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employees</title>
</head>
<body>
    <h1>Employee List</h1>
    <table border="1">
        <tr>
            <th>Employee No</th>
            <th>Employee Name</th>
            <th>Place of Work</th>
            <th>Phone No</th>
            <th>Action</th>
        </tr>
        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            out.print("haha");
            if (employees != null) {
                for (Employee employee : employees) {
            %>
                <tr>
                    <td><%= employee.getEmployeeNo() %></td>
                    <td><%= employee.getEmployeeName() %></td>
                    <td><%= employee.getPlaceOfWork() %></td>
                    <td><%= employee.getPhoneNo() %></td>
                    <td>
                        <a href="EmployeeServlet?action=edit&employeeNo=<%= employee.getEmployeeNo() %>">Edit</a>
                    </td>
                </tr>
            <%
                }
            }
            %>

    </table>
    <br>
    <a href="add_employee.jsp">Add New Employee</a>
</body>
</html>
