<%-- 
    Document   : create
    Created on : Jul 18, 2022, 11:01:58 AM
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
        <h1>Student Manager</h1>
        <form action="" method="POST">
            <table>
            <tr>
                <td>Roll number</td>
                <td><input type="text" name="rollNumber"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="password"></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add"></td>
                <td><input type="reset"></td>
            </tr>            
        </table>            
        </form>
    </body>
</html>
