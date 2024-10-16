<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is hello, haha</h1>
        <%
        String username = request.getParameter("username");
        int x = Integer.valueOf(request.getParameter("x"));
        int y = Integer.valueOf(request.getParameter("y"));
        int sum = x + y;
        out.println(String.format("sum = %d", sum));
        if (username != null && !username.isEmpty()) {
            out.println("<p>Xin chào, " + username + "!</p>");
        } else {
            out.println("<p>Vui lòng nhập tên của bạn.</p>");
        }
    %>
    <h2>something...</h2>
    <%
        out.println(String.format("x = %d", x));
    %>
    </body>
</html>
