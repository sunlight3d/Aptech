<%@ page import="java.util.List" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="com.example.ejb.StudentBean" %>
<%@ page import="com.example.entity.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students</title>
</head>
<body>
    <h1>Student List</h1>
    <%
        StudentBean studentBean = null;
        try {
            Context context = new InitialContext();
            studentBean = (StudentBean) context.lookup("java:com.mycompany.question01.StudentBean");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        if (studentBean != null) {
            List<Student> students = studentBean.listStudents();
    %>
    <table border="1">
        <tr>
            <th>Roll Number</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
        </tr>
        <%
            for (Student student : students) {
        %>
        <tr>
            <td><%= student.getRollNumber() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getEmail() %></td>
            <td><%= student.getAge() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
    %>
    <p>Error: Could not retrieve student list.</p>
    <%
        }
    %>
</body>
</html>
