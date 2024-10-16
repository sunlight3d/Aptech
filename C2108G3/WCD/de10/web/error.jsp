<%-- 
    Document   : error
    Created on : Sep 27, 2023, 9:48:11 AM
    Author     : hoangnd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head><body>
        <h1><%= request.getAttribute("errorMessage") %></h1>        
    </body>        
</html>
