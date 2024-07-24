<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
        <style>
            .error {
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Register</h1>
        <form action="UserServlet" method="POST">
            <div>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" >
                <% 
                    Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
                    if (errors != null && errors.containsKey("username")) {
                        out.println("<span class='error'>" + errors.get("username") + "</span>");
                    }
                %>
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" >
                <% 
                    if (errors != null && errors.containsKey("password")) {
                        out.println("<span class='error'>" + errors.get("password") + "</span>");
                    }
                %>
            </div>
            <div>
                <label for="retypedPassword">Retype Password:</label>
                <input type="password" id="retypedPassword" name="retypedPassword" >
                <% 
                    if (errors != null && errors.containsKey("retypedPassword")) {
                        out.println("<span class='error'>" + errors.get("retypedPassword") + "</span>");
                    }
                %>
            </div>
            <div>
                <label for="phoneNumber">Phone Number:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" >
                <% 
                    if (errors != null && errors.containsKey("phoneNumber")) {
                        out.println("<span class='error'>" + errors.get("phoneNumber") + "</span>");
                    }
                %>
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" >
                <% 
                    if (errors != null && errors.containsKey("email")) {
                        out.println("<span class='error'>" + errors.get("email") + "</span>");
                    }
                %>
            </div>
            <div>
                <button type="submit">Register</button>
            </div>
        </form>
    </body>
</html>
