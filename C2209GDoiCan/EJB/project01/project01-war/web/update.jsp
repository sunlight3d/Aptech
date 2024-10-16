<%@page import="com.example.ejb.Student"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
    <h2>Update Student</h2>
    <%
        // Lấy thông tin sinh viên từ request attribute
        Student student = (Student) request.getAttribute("student");

        if (student != null) {
    %>
    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="id" value="<%= student.getId() %>" />
        <p>
            Name: <input type="text" name="name" value="<%= student.getName() %>" required />
        </p>
        <p>
            Age: <input type="number" name="age" value="<%= student.getAge() %>" required />
        </p>
        <p>
            Email: <input type="email" name="email" value="<%= student.getEmail() %>" required />
        </p>
        <p>
            <input type="submit" value="Update Student" />
        </p>
    </form>
    <%
        } else {
    %>
    <p>Student not found!</p>
    <%
        }
    %>

<!-- Nút quay lại danh sách sinh viên -->
<p>
    <form action="StudentServlet" method="get">
        <input type="submit" value="Back to List" />
    </form>
</p>

</body>
</html>
