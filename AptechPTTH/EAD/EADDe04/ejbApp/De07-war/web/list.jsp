
<%@page import="java.util.List"%>
<!-- <%@page import="models.Student"%> -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student Manager</h1>

        <table style="width:100%">
             
        <%            
            List<Student> students = (List<Student>)request.getAttribute("students");            
                    for(Student student: students) {
                        out.print("<tr>");        
                        out.print("<td>"+student.getRollnumber()+"</td>");
                        out.print("<td>"+student.getName()+"</td>");
                        out.print("<td>"+student.getEmail()+"</td>");
                        out.print("<td>"+student.getPhoneNo()+"</td>");
                        out.print("<td><a href='StudentServlet?type=delete&rollNumber="
                                +student.getRollnumber()+"'>"+student.getRollnumber()+"</a></td>");
                        out.print("</tr>");                    
                    }
                %>       
      </table>
        <a href="/create.jsp">Add Student</a>  
        <a href="/index.jsp">Index</a> 
    </body>
</html>
