<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation Page</title>
</head>
<body>
    <h2>Registration Successful!</h2>
    
    <%-- Retrieve the cookie value --%>
    <% 
        Cookie[] cookies = request.getCookies();
    %>    
    <%-- Display the saved form data --%>
    <p>Name: <%= cookies[0].getValue() %></p>
        <p>Address: <%= cookies[1].getValue() %></p>
        <p>Phone No: <%= cookies[2].getValue() %></p>
        <p>Class Name: <%= cookies[3].getValue() %></p>
</body>
</html>