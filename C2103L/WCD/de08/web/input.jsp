<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Input Form</title>
</head>
<body>
    <h2>Input Form</h2>
    <form action="UserServlet" method="POST">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required>
        <br>
        
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required>
        <br>
        
        <label for="password">Enter Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        
        <label for="confirmPassword">Re-enter Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>
        <br>
        
        <input type="submit" name="action" value="Display">
        <input type="reset" value="Clear">
    </form>
    
    <%-- Ki?m tra n?u có l?i password không trùng --%>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
</body>
</html>

