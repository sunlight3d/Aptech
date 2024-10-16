<%-- 
    Document   : login
    Created on : Sep 27, 2023, 9:26:47 AM
    Author     : hoangnd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="UserServlet" method="post">            
            <table>
            <tr>
                <td>
                    Username
                </td>
                <td>
                    <input type="text" name="username" required>
                </td>
            </tr>
            <tr>
                <td>
                    Password
                </td>
                <td>
                    <input type="password" name="username" required>
                </td>
            </tr>
            <tr>
                <td>
                    
                </td>
                <td>
                    <input type="submit" value="Login">
                </td>
            </tr>
        </table>
        </form>        
    </body>
</html>
<!--
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL
);
INSERT INTO users(username, password) VALUES('admin', 'admin');
-->