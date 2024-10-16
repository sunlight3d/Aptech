<%@page import="java.util.List"%>
<%@page import="services.Employee"%>
<%@page import="services.EmployeeWS"%>
<%@page import="services.EmployeeWS_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1>Insert new Employee</h1>
            <form method="GET">
                <table>
                    <tr>
                        <td>Employee No</td>
                        <td><input type="text" required name="employeeNo"/></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" required name="employeeName"/></td>
                    </tr>
                    <tr>
                        <td>Place Of Work</td>
                        <td><input type="text" required name="placeOfWork"/></td>
                    </tr>
                    <tr>
                        <td>Phone No</td>
                        <td><input type="text" required name="phoneNo"/></td>
                    </tr>
                    <tr>                    
                        <td><input type="submit" value="Submit Query"></td>
                        <td><input type="reset" value="Reset"></td>
                    </tr>
                </table> 
                <a href="./index.jsp" >Back to List</a>
            </form>
            <%
                String employeeNo = request.getParameter("employeeNo");
                String employeeName = request.getParameter("employeeName");
                String placeOfWork = request.getParameter("placeOfWork");
                String phoneNo = request.getParameter("phoneNo");
                if(employeeNo == null || employeeName == null ||
                        placeOfWork == null || phoneNo == null) {
                    return;
                }
                try {
                    EmployeeWS_Service service = new EmployeeWS_Service();
                    EmployeeWS port = service.getEmployeeWSPort();
                    Employee employee = port.insertEmployee(employeeNo, employeeName, placeOfWork, phoneNo);
                } catch(Exception e) {
                    out.println("Cannot insert employee, error: "+e.toString());
                }
            %>
        </center>        
    </body>
</html>