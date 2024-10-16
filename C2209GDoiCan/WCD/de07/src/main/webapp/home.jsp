<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Information</title>
</head>
<body>
    <h1>This is user information</h1>
    <%
        // Check if cookies exist and retrieve user information
        Cookie[] cookies = request.getCookies();
        String name = "";
        String className = "";
        String address = "";
        String phoneNumber = "";
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("name".equals(cookie.getName())) {
                    name = cookie.getValue();
                } else if ("className".equals(cookie.getName())) {
                    className = cookie.getValue();
                } else if ("address".equals(cookie.getName())) {
                    address = cookie.getValue();
                } else if ("phoneNumber".equals(cookie.getName())) {
                    phoneNumber = cookie.getValue();
                }
            }
        }
    %>
    <p><strong>Name:</strong> <%= name %></p>
    <p><strong>Class Name:</strong> <%= className %></p>
    <p><strong>Address:</strong> <%= address %></p>
    <p><strong>Phone Number:</strong> <%= phoneNumber %></p>
</body>
</html>
