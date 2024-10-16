<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome to the System</h1>

    <%
        // L?y th�ng tin ng??i d�ng t? session
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
