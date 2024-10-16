<%-- 
    Document   : register
    Created on : Jun 24, 2022, 1:56:08 PM
    Author     : w11
--%>

<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Hashtable<String, Object> errors = request.getAttribute("errors") == null ? new Hashtable<String, Object>():
                        (Hashtable<String, Object>)request.getAttribute("errors") ;            
            String firstNameError = errors.containsKey("firstName") ? (String)errors.get("firstName") : "";
            String lastNameError = errors.containsKey("lastName") ? (String)errors.get("lastName") : "";
            String usernameError = errors.containsKey("username") ? (String)errors.get("username") : "";
            String passwordError = errors.containsKey("password") ? (String)errors.get("password") : "";
            String retypedPasswordError = errors.containsKey("retypedPassword") ? (String)errors.get("retypedPassword") : "";
            String twoPasswordSameError = errors.containsKey("twoPasswordSame") ? (String)errors.get("twoPasswordSame") : "";    
        %>
    </head>
    <body>
        <center>
            <h1>Create a Gmail Account</h1>
            <form method="POST" action="UserServlet">
                <table>
                <tr>
                    
                    <td>First name</td>
                    <td><input type="text" name="firstName" >
                        <span style="color: red;"><%=firstNameError%></span>
                    </td>
                </tr>
                <tr>
                    <td>Last name</td>
                    <td><input type="text" name="lastName">
                        <span style="color: red;"><%=lastNameError%></span>
                    </td>
                </tr>
                <tr>
                    <td>Designed login name </td>
                    <td><input type="text" name="username">
                        <span>@gmail.com</span>
                        <span style="color: red;"><%=usernameError%></span>
                    </td>
                </tr>
                <tr>
                    <td>Choose a password </td>
                    <td><input type="password" name="password">
                        <span style="color: red;"><%=passwordError%></span>
                    </td>
                </tr>
                <tr>
                    <td>Re-enter password </td>
                    <td><input type="password" name="retypedPassword">
                        <span style="color: red;"><%=retypedPasswordError%></span>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <span style="color: red;"><%=twoPasswordSameError%></span>
                    </td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Register"/></td>
                    <td><input type="reset" value="Reset"/></td>
                </tr>
            </table>
            </form>
        </center>        
    </body>
</html>
                                