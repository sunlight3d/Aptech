<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome to the System</h1>

    <%
        // L?y thông tin ng??i dùng t? session
        String username = (String) session.getAttribute("username");

        if (username != null) {
    %>
    <p>Hello, <%= username %>! You are now logged in.</p>
    <p>This is your welcome page.</p>
    <%
        } else {
    %>
        <p>You are not logged in. Please <a href="login.jsp">log in</a> to continue.</p>
    <%
        }
    %>
</body>
</html>
