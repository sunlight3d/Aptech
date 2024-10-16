<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        .error {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
    
    <form action="UserServlet" method="post">
        <center>
            <h1>Gmail Account</h1>
            <% 
                
                Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
                if (errors == null) {
                    errors = new HashMap<>();
                }

                String firstNameError = errors.getOrDefault("firstNameError", "");
                String lastNameError = errors.getOrDefault("lastNameError", "");
                String emailError = errors.getOrDefault("emailError", "");
                String passwordError = errors.getOrDefault("passwordError", "");
                            
            %>
            <a href="/UserServlet">Create Account</a>
            <table>
                <tbody>
                    <tr>
                        <td>
                            <label for="firstName">First Name:</label>
                        </td>
                        <td>
                            <input type="text" id="firstName" name="firstName">
                            <span class="error"><%=firstNameError%></span>
                        </td>
                    </tr>
                            
                    <tr>
                        <td>
                            <label for="lastName">Last Name:</label>
                        </td>
                        <td>
                            <input type="text" id="lastName" name="lastName">
                            <span class="error"><%=lastNameError%></span>                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="email">Email:</label>        
                        </td>
                        <td>
                            <input type="email" id="email" name="email">                            
                            <span class="error"><%=emailError%></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="password">Password:</label>        
                        </td>
                        <td>
                            <input type="password" id="password" name="password">
                            <span class="error"><%=passwordError%></span>                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="confirmPassword">Re-enter Password:</label>        
                        </td>
                        <td>
                            <input type="password" id="confirmPassword" name="confirmPassword">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Register">        
                        </td>
                        <td>
                            <input type="reset" value="Reset">                
                        </td>
                    </tr>                                
                </tbody>
            </table>        
        </center>
    </form>
</body>
</html>
