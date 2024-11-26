<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List" %>
<%@page import="models.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Form</title>
</head>
<body>
    <h1>Register</h1>
    <form action="${pageContext.request.contextPath}/users" method="post">
        <!-- Ẩn hành động để servlet xử lý đúng chức năng -->
        <input type="hidden" name="_action" value="register">

        <label for="fullname">Full name:</label>
        <input type="text" id="fullname" name="fullname" required>
        <br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br><br>

        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>
        <br><br>

        <button type="submit">Register</button>
    </form>

    <p>Already have an account? <a href="${pageContext.request.contextPath}/users?_type=login">Login here</a></p>
</body>
</html>
