
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1>Input your information</h1>
            <form action="/myapp/UserServlet" method="GET" >
                 <table style="width:30%">                
                    <tr>
                      <td>First name</td>
                      <td><input type="text" required placeholder="Enter firstname" name="firstName"/></td>                  
                    </tr>                
                    <tr>
                      <td>First name</td>
                      <td><input type="text" required placeholder="Enter lastname" name="lastName"/></td>                  
                    </tr>                
                    <tr>
                      <td>Enter password:</td>
                      <td><input type="password" required  name="password"/></td>                  
                    </tr>                
                    <tr>
                      <td>Retype password:</td>
                      <td><input type="password" required  name="retypePassword"/></td>                  
                    </tr>                
                    <tr>
                        <td><input type="submit" value="Display"></td>
                        <td><input type="reset" value="Clear"></td>
                    </tr>                
                  </table> 
            </form>
        </center>
        
    </body>
</html>
