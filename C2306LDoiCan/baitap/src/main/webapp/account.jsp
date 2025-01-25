<%@ page import="vn.aptech.servlet.database.entity.Account" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accounts</title>
</head>
<body>
<%
    List<Account> accounts = (List<Account>) request.getAttribute("accounts");
%>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Username</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Password</th>
    </tr>
    <% for (Account account : accounts) { %>
        <tr>
            <td><%=account.getId()%></td>
            <td><%=account.getName()%></td>
            <td><%=account.getUsername()%></td>
            <td><%=account.getEmail()%></td>
            <td><%=account.getMobile()%></td>
            <td><%=account.getPassword()%></td>
        </tr>
    <%}%>
</table>
<form action="students.jsp" method="post">
    <table>
        <tr>
            <td>Name: </td>
            <td><input type="text" placeholder="Name" name="name"></td>
        </tr>
        <tr>
            <td>Username: </td>
            <td><input type="text" placeholder="UserName" name="username"></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><input type="text" placeholder="Email" name="email"></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><input type="password" placeholder="Password" name="password"></td>
        </tr>
        <tr>
            <td>Mobile: </td>
            <td><input type="text" placeholder="Mobile" name="mobile"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
