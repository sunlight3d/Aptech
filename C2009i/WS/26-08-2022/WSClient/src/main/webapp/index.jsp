<%@page import="services.Employee"%>
<%@page import="services.EmployeeWS"%>
<%@page import="services.EmployeeWS_Service"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
    table, th, td {
      border:1px solid black;
      padding: 10px;
      border-collapse: collapse;
    }
    </style>
    <body>
    <center>
        <h1>Employee information</h1>
        <form method='GET'>
        <table >
        <tr>
          <th>Employee No</th>
          <th>Name</th>
          <th>Place of Work</th>
          <th>Phone No</th>
          <th>Delete</th>
        </tr>
         <%
            //call service, like WCF trong C#
            EmployeeWS_Service service = new EmployeeWS_Service();
            EmployeeWS port = service.getEmployeeWSPort();
            String deleteEmployeeNo = request.getParameter("deleteEmployeeNo");
            if(deleteEmployeeNo != null) {
                try {
                    port.deleteEmployee(deleteEmployeeNo);
                } catch(Exception e) {
                    System.err.println("dsjhjds");
                }
            }            
            List<Employee> employees = port.findAll();                        
            for(Employee employee: employees) {
                out.println("<tr>");
                out.println("<td>"+employee.getEmployeeNo()+"</td>");
                out.println("<td>"+employee.getEmployeeName()+"</td>");
                out.println("<td>"+employee.getPlaceOfWork()+"</td>");
                out.println("<td>"+employee.getPhoneNo()+"</td>");
                out.println("<td><a href='./index.jsp?deleteEmployeeNo="
                        +employee.getEmployeeNo()+"'>Delete</td>");
                out.println("</tr>");                
            }
            
        %>        
      </table>
      
      </form>
      <a href="./addnew.jsp">Add New</a>
      
       
    </center>        
    </body>
</html>