<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login Form</h2>
    <%-- Hiển thị thông báo lỗi --%>
    <% if (request.getAttribute("error") != null) { %>
        <div style="color: red;">Invalid username or password</div>
    <% } %>
    <form action="login" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <button type="submit">Login</button>
            <button type="reset">Reset</button>
        </div>
    </form>
</body>
</html>
