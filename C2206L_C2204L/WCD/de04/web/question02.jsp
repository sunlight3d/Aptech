<%-- 
    Document   : question02
    Created on : Dec 13, 2023, 8:34:54 PM
    Author     : Nguyen Duc Hoang
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Language Form</title>
</head>
<body>
    <h1>Language Form</h1>
    <div>
        <a href="Question02Servlet?lang=vi">Tiếng Việt</a> | 
        <a href="Question02Servlet?lang=en">English</a><br><br>
        <label for="fullName">Họ tên:</label>
        <input type="text" name="fullName" id="fullName"><br><br>
        <label for="gender">Giới tính:</label>
        <input type="radio" name="gender" value="male"><%=request.getAttribute("male")%>
        <input type="radio" name="gender" value="female">
        <%=request.getAttribute("female")%>
        <br><br>
        <label for="birthdate">Ngày sinh:</label>
        <input type="text" name="birthdate" id="birthdate"><br><br>
        <label for="hometown">Quê quán:</label>
        <input type="text" name="hometown" id="hometown"><br><br>
        <input type="submit" name="submit" value="Xử lý">
        <input type="reset" name="reset" value="Làm lại">
    </div>
</body>
</html>