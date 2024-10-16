<%-- 
    Document   : temp
    Created on : Jun 22, 2023, 7:33:56 PM
    Author     : w11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is temp</h1>
        <p>Dữ liệu từ ProductServlet: <%= request.getAttribute("data") %></p>
    </body>
</html>
