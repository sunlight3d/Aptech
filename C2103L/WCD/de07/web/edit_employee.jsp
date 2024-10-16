<%@page import="models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Employee</title>
</head>
<body>
    <h1>Edit Employee</h1>
    <%
        Employee employee = (Employee) request.getAttribute("employee");

        if (employee != null) {
        %>
            <form action="EmployeeServlet" method="POST">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="employeeNo" value="<%= employee.getEmployeeNo() %>">

                <label for="employeeName">Employee Name:</label>
                <input type="text" id="employeeName" name="employeeName" value="<%= employee.getEmployeeName() %>" required>
                <br>

                <label for="placeOfWork">Place of Work:</label>
                <input type="text" id="placeOfWork" name="placeOfWork" value="<%= employee.getPlaceOfWork() %>" required>
                <br>

                <label for="phoneNo">Phone No:</label>
                <input type="text" id="phoneNo" name="phoneNo" value="<%= employee.getPhoneNo() %>">
                <br>        
                <input type="submit" value="Save">
            </form>
        <%
        }
        %>

</body>
</html>
