<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Employee</title>
</head>
<body>
    <h1>Add New Employee</h1>
    <form action="EmployeeServlet" method="post">
        <label for="employeeNo">Employee Number:</label>
        <input type="text" id="employeeNo" name="employeeNo" required><br>
        <span style="color: red;">
            <c:if test="${empty param.employeeNo}">
                Employee Number is required.
            </c:if>
        </span>

        <label for="employeeName">Employee Name:</label>
        <input type="text" id="employeeName" name="employeeName" required><br>
        <span style="color: red;">
            <c:if test="${empty param.employeeName}">
                Employee Name is required.
            </c:if>
        </span>

        <label for="placeOfWork">Place of Work:</label>
        <input type="text" id="placeOfWork" name="placeOfWork"><br>

        <label for="phoneNo">Phone Number:</label>
        <input type="text" id="phoneNo" name="phoneNo"><br>

        <input type="submit" value="Submit query">
        <input type="reset" value="Reset">
    </form>
    <br>
    <a href="employees.jsp">Back to Employee List</a>
</body>
</html>
