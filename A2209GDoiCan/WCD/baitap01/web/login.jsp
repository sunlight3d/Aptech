<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List" %>
<%@page import="models.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body>
    <h1>Login</h1>
    <form action="${pageContext.request.contextPath}/users" method="post">
        <!-- Ẩn hành động để servlet xử lý đúng chức năng -->   
        <input type="hidden" name="_action" value="login">
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br><br>
        
        <button type="submit">Login</button>
    </form>

    <p>Don't have an account? 
        <a href="${pageContext.request.contextPath}/users?_type=register">Register here
        </a>
    </p>
</body>
</html>
