

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Detail student's information</h1>
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if(cookie.getName().toUpperCase().equals("JSESSIONID")) {
                        continue;
                    }
                    out.print(cookie.getName( ) + ": ");
                    out.print(cookie.getValue( )+" <br/>");
                }
            }            
        %>
    </body>
</html>
