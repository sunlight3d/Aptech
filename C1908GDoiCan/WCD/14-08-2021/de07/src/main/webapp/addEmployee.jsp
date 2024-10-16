<%-- 
    
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .error{
                color: red;
            }
        </style>
    </head>
    <body>        
    <center>
        <h1>Add Employee</h1>
        <form method="POST" action="/de07/EmployeeServlet">
            <table style="width:50%">
            <tr>
              <td>Employee No</td>
              <td>
                  <input type="text" name="employeeNo" />
                  <span class="error">${errors.employeeNo} </span>
              </td>              
              
            </tr>
            <tr>
              <td>Name</td>              
              <td>
                  <input type="text" name="name"/>
                  <span class="error">${errors.name} </span>
              </td>              
            </tr>
            <tr>
              <td>placeOfWork</td>
              <td>
                  <input type="text" name="placeOfWork"/>
                  <span class="error">${errors.placeOfWork} </span>
              </td>              
            </tr>
            <tr>
              <td>phoneNo</td>              
              <td>
                  <input type="text" name="phoneNo"/>
                  <span class="error">${errors.phoneNo} </span>
              </td>
            </tr>            
            <tr>
                <td><input type="submit" value="Submit Query"/></td>              
                <td><input type="reset" value="Reset"/></td>              
            </tr>            
          </table>
            <a href="employees.jsp"> Back to List</a>
        </form>
    </center>
    </body>
</html>
