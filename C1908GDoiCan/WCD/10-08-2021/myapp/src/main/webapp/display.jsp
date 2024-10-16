<%-- 
    Document   : display
    Created on : Aug 12, 2021, 9:07:26 AM
    Author     : sunli
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>    
    <body>
        <h1>This is Display</h1>        
        <%
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.err.println(cookie.getName());
                System.err.println(cookie.getValue());
                out.println("<p>"+cookie.getName()+" - "+cookie.getValue()+"</p>");
            }
        }
        %>
    </body>
</html>
