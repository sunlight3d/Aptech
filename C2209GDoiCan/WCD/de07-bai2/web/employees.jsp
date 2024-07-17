<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Employee" %>  

<html>
<head>
    <title>Employee List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>List of Employees</h1>
<table>
    <thead>
        <tr>
            <th>Employee Number</th>
            <th>Name</th>
            <th>Place of Work</th>
            <th>Phone Number</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <% 
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            if (employees != null) {
                for (Employee employee : employees) {
        %>
                    <tr>
                        <td><%= employee.getEmployeeNo() %></td>
                        <td><%= employee.getEmployeeName() %></td>
                        <td><%= employee.getPlaceOfWork() %></td>
                        <td><%= employee.getPhoneNo() %></td>
                        <td>
                            <form action="EmployeeServlet" method="post">
                                <input type="hidden" name="employeeNo" 
                                       value="<%= employee.getEmployeeNo() %>" />
                                <input type="submit" value="Delete" />
                                <input type="hidden" name="action" value="delete" />
                            </form>
                        </td>
                    </tr>
        <% 
                }
            } else {
        %>
                <tr>
                    <td colspan="5">No employees found.</td>
                </tr>
        <% 
            }
        %>
    </tbody>
</table>
</body>
</html>
