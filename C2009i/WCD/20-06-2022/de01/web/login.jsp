<%-- 
    Document   : login
    Created on : Jun 20, 2022, 10:36:17 AM
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
        <h1>LOGIN FORM</h1>
        <form action="UserServlet" method="POST">
            <table>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login"></td>
                <td><input type="reset"></td>
            </tr>            
        </table>
            <p style="color: red;">
                <%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
            </p>
        </form>
        
    </body>
</html>
