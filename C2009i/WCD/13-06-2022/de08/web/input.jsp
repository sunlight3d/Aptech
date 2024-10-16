<%-- 
    Document   : input
    Created on : Jun 17, 2022, 4:29:00 PM
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
        <p style="color: red;"><%= request.getAttribute("error") == null ? "":
                                    (String)request.getAttribute("error") %></p>
        <h1>Input your information</h1>
        <form method="POST" action="InputServlet">
            <table>
                <tr>
                    <td>First name</td>
                    <td><input type="text" name="firstName"></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>Retype password</td>
                    <td><input type="password" name="retypePassword"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Display"></td>
                    <td><input type="reset" value="Clear"></td>
                </tr> 
            </table>                        
        </form>
    </body>
</html>
