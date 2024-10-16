<%-- 
    Document   : studentDisplay
    Created on : Mar 24, 2024, 10:47:27 PM
    Author     : ChungTV
--%>

<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Student Information</title>
    </head>
    <body>
        <h2>Student Information</h2>
    <% 
        Cookie[] cookies = request.getCookies();
       
        String name = "", address = "", phone = "", className = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    name = cookie.getValue();
                } else if (cookie.getName().equals("address")) {
                    address = cookie.getValue();
                } else if (cookie.getName().equals("phone")) {
                    phone = cookie.getValue();
                } else if (cookie.getName().equals("className")) {
                    className = cookie.getValue();
                }
            }
        }
    %>
    
    <p>Name: <%= name %></p>
    <p>Address: <%= address %></p>
    <p>Phone No: <%= phone %></p>
    <p>Class Name: <%= className %></p>
    </body>
</html>
