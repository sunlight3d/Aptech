<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Form</title>
</head>
<body>
    <h1>LOGIN FORM</h1>
    <form method="POST" action="UserServlet">
        <table>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
