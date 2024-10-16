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
            String employeeNoError = errors.containsKey("employeeNo") ? (String)errors.get("employeeNo") : "";
            String nameError = errors.containsKey("name") ? (String)errors.get("name") : "";
            String placeOfWorkError = errors.containsKey("placeOfWork") ? (String)errors.get("placeOfWork") : "";
            String phoneNoError = errors.containsKey("phoneNo") ? (String)errors.get("phoneNo") : "";            
            String existError = errors.containsKey("exist") ? (String)errors.get("exist") : "";            
        %>
    </head>
    <body>
        <center>
            <h1>Insert Employee</h1>
            <span style="color: red;"><%=existError%></span>        
            <form method="POST" action="EmployeeServlet">
                <table>
                <tr>
                    
                    <td>EmployeeNo</td>
                    <td><input type="text" name="employeeNo" >
                        <span style="color: red;"><%=employeeNoError%></span>
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name">
                        <span style="color: red;"><%=nameError%></span>
                    </td>
                </tr>
                <tr>
                    <td>placeOfWork</td>
                    <td><input type="text" name="placeOfWork">                        
                        <span style="color: red;"><%=placeOfWorkError%></span>
                    </td>
                </tr>
                <tr>
                    <td>Phone no </td>
                    <td><input type="text" name="phoneNo">
                        <span style="color: red;"><%=phoneNoError%></span>
                    </td>
                </tr>                                
                
                <tr>
                    <td><input type="submit" value="Submit Query"/></td>
                    <td><input type="reset" value="Reset"/></td>
                </tr>
            </table>
                    <a href="EmployeeServlet">Back to list</a>        
            </form>
            
        </center>        
    </body>
</html>
                                