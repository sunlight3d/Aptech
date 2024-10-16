<%@ page import="java.util.List" %>
<%@ page import="entities.Employee" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is Employees</h1>           
        <table class="table">
        <tr>
            <th>Employee No</th>
            <th>Employee Name</th>
            <th>Place of Work</th>
            <th>Phone Number</th>
            <th>Delete</th>
        </tr>
       
        <% 
            List<Employee> employees = (List<Employee>) request.getAttribute("employees"); 
            int xx = 11;
        %>
        <% for (Employee employee : employees) { %>
            <tr>
                <td><%= employee.getEmployeeNo() %></td>
                <td><%= employee.getEmployeeName() %></td>
                <td><%= employee.getPlaceOfWork() %></td>
                <td><%= employee.getPhoneNumber() %></td>
                <td>
                <button onclick="confirmDelete('<%= employee.getEmployeeNo() %>')">
                    Delete
                </button>
        </td>
            </tr>
        <% } %>
    </table>
    <div>
         <% 
            String contextPath = ((HttpServletRequest) request).getContextPath();   
        %>
       <a href="<%= contextPath %>/addEmployee.jsp">Add New</a>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function confirmDelete(employeeNo) {
        debugger
        const confirmation = confirm("Are you sure you want to delete employee " + employeeNo + "?");
        if (confirmation) {
            // Gửi yêu cầu xóa nhân viên đến servlet
            window.location.href = "/de07/EmployeeServlet?action=delete&employeeNo=" + employeeNo;
        }
    }
    </script>
    </body>
</html>
