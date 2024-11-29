<%@page import="com.example.ejb.Exam"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Exam</title>
</head>
<body>
    <h2>Update Exam</h2>
    <%
        // Retrieve the exam information from the request attribute
        Exam exam = (Exam) request.getAttribute("exam");

        if (exam != null) {
    %>
    <form action="ExamServlet" method="post">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="id" value="<%= exam.getId() %>" />
        <p>
            Name: <input type="text" name="name" value="<%= exam.getName() %>" required />
        </p>
        <p>
            Duration (minutes): <input type="number" name="duration" value="<%= exam.getDuration() %>" required />
        </p>
        <p>
            Description: 
            <textarea name="description" rows="4" cols="50" required><%= exam.getDescription() %></textarea>
        </p>
        <p>
            <input type="submit" value="Update Exam" />
        </p>
    </form>
    <%
        } else {
    %>
    <p>Exam not found!</p>
    <%
        }
    %>

    <!-- Back to Exam List Button -->
    <p>
        <form action="ExamServlet" method="get">
            <input type="hidden" name="action" value="list" />
            <input type="submit" value="Back to List" />
        </form>
    </p>

</body>
</html>
