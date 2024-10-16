<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Student</title>
</head>
<body>
    <h1>Delete Student</h1>
    
    <p>Are you sure you want to delete this student?</p>
    <form action="deleteStudent" method="post">
        <input type="hidden" name="rollnumber" value="${param.rollnumber}">
        <input type="submit" value="Delete">
    </form>
    
    <p><a href="index.jsp">Back to Student List</a></p>
</body>
</html>
