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
    <title>Create Student</title>
</head>
<body>
    <h1>Create a New Student</h1>
    <form method="post" action="create.jsp">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>
        <input type="submit" value="Create">
    </form>
    <%
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));

            StudentBean studentBean = null;
            try {
                Context context = new InitialContext();
                studentBean = (StudentBean) context.lookup("java:com.mycompany.question01.StudentBean");
            } catch (NamingException e) {
                e.printStackTrace();
            }

            if (studentBean != null) {
                Student student = new Student();
                student.setName(name);
                student.setEmail(email);
                student.setAge(age);
                studentBean.createStudent(student);
                out.println("<p>Student created successfully!</p>");
            } else {
                out.println("<p>Error: Could not create student.</p>");
            }
        }
    %>
    <p><a href="students.jsp">View Student List</a></p>
</body>
</html>
