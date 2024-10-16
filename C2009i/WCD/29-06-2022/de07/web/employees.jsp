<%-- 
    Document   : employees
    Created on : Jun 29, 2022, 2:21:45 PM
    Author     : w11
--%>

<%@page import="java.util.List"%>
<%@page import="models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <center>
            <h1>Employee Information</h1>
            <form>                                            
            <table>
                <tr>
                    <th>
                        Employee No
                    </th>
                    <th>
                        Name
                    </th>
                    <th>
                        place of work
                    </th>
                    <th>
                        Phone No
                    </th>
                    <th>
                        Delete
                    </th>                
                </tr>
                <%            
                    List<Employee> employees = (List<Employee>)request.getAttribute("employees");            
                    for(Employee employee: employees) {
                        out.print("<tr>");        
                        out.print("<td>"+employee.getEmployeeNo()+"</td>");
                        out.print("<td>"+employee.getEmployeeName()+"</td>");
                        out.print("<td>"+employee.getPlaceOfWork()+"</td>");
                        out.print("<td>"+employee.getPhoneNo()+"</td>");
                        out.print("<td><a href='EmployeeServlet?type=delete&employeeNo="
                                +employee.getEmployeeNo()+"'>"+employee.getEmployeeNo()+"</a></td>");
                        out.print("</tr>");                    
                    }
                %>               
            </table>
            <a href='EmployeeServlet?type=insert'>Add New</a>
        </form>
        </center>
    </body>
</html>
