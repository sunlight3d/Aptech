<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index</title>
</head>
<body>
    <h2>Welcome to Index Page</h2>
    
    <% if (session.getAttribute("username") != null && session.getAttribute("password") != null) { %>
        <p>Username: <%= session.getAttribute("username") %></p>
        <p>Password: <%= session.getAttribute("password") %></p>
    <% } else { %>
        <p>User is not logged in.</p>
    <% } %>
    
    <a href="login.jsp">Logout</a>
</body>
</html>
