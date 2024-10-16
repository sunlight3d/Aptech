<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h2>Registration</h2>
    
    <form action="UserServlet" method="POST">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName">
        <br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName">
        <br>
        <label for="loginName">Login Name:</label>
        <input type="text" id="loginName" name="loginName">
        <span>@gmail.com</span>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <br>
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword">
        <br>        
        <% if (request.getAttribute("passwordError") != null) { %>
            <p class="error"><%= request.getAttribute("passwordError") %></p>
        <% } %>
        <input type="submit" value="Register">
        <input type="reset" value="Reset">
    </form>
</body>
</html>
