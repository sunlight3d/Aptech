<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Hashtable<String, String> errors = 
                    request.getAttribute("errors") == null ? new Hashtable<String, String>():
                    (Hashtable<String, String>)request.getAttribute("errors");
            String errorName = errors.getOrDefault("name", "");
            String errorAddress = errors.getOrDefault("address", "");
            String errorPhoneNo = errors.getOrDefault("phoneNo", "");
            String errorClassName = errors.getOrDefault("className", "");
        %>
        <h1>Student Registration Form</h1>
        <form action="Question2Servlet" method="POST">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" >
                    <span style="color: red;"><%=errorName%></span>
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address">
                <span style="color: red;"><%=errorAddress%></span>
                </td>
            </tr>
            <tr>
                <td>Phone No</td>
                <td><input type="text" name="phoneNo">
                    <span style="color: red;"><%=errorPhoneNo%></span>
                </td>
            </tr>
            <tr>
                <td>Class Name</td>
                <td><input type="text" name="className">
                    <span style="color: red;"><%=errorClassName%></span>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit Query"></td>
                <td></td>
            </tr>
        </table>
            </form>
    </body>
</html>
