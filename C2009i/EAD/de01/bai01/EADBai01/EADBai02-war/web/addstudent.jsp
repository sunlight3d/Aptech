<%-- 
    Document   : addstudent.jsp
    Created on : Aug 19, 2022, 3:46:55 PM
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
        <form action="/StudentServlet" method="post">
        <table border="1">
            <thead>
                
            </thead>
            <tbody>
                <tr>
                    <td>Roll number</td>
                    <td><input type="text" name="rollNumber"/></td>
                </tr>
                <tr>
                    <td>Roll number</td>
                    <td><input type="text" name="fullName"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><input type="text" name="age"/></td>
                </tr>
                <tr>
                    <td><input type='submit' value="Add"></td>
                    <td><input type='clear' value="Clear"></td>
                </tr>
            </tbody>
        </table>
            <a href="/StudentServlet">List of Student</a>
            <a href="/">Index</a>
</form>
    </body>
</html>
