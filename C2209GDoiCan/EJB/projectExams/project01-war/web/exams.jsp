<%@page import="java.util.List"%>
<%@page import="com.example.ejb.Exam"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exam List</title>
    <style>
        table {
            width: 70%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
    <h2>Exam List</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Exam Name</th>
                <th>Duration (minutes)</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
    <%
        // Retrieve the list of exams from the request attribute
        List<Exam> exams = (List<Exam>) request.getAttribute("exams");
        
        // Check if the list is not empty
        if (exams != null) {
            for (Exam exam : exams) {
    %>
                <tr>
                    <td><%= exam.getId() %></td>
                    <td><%= exam.getName() %></td>
                    <td><%= exam.getDuration() %></td>
                    <td><%= exam.getDescription() %></td>
                    <!-- Delete Button -->
                    <td>
                        <form action="ExamServlet" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="delete"/>
                            <input type="hidden" name="id" value="<%= exam.getId() %>"/>
                            <input type="submit" value="Delete" />
                        </form>
                        <!-- Update Button -->
                        <form action="ExamServlet" method="get" style="display:inline;">
                            <input type="hidden" name="action" value="edit"/>
                            <input type="hidden" name="id" value="<%= exam.getId() %>"/>
                            <input type="submit" value="Update" />
                        </form>
                    </td>
                </tr>
    <%
            }
        } else {
    %>
                <tr>
                    <td colspan="5" style="text-align: center;">No exams available</td>
                </tr>
    <%
        }
    %>
        </tbody>
    </table>

    <!-- Add Exam Button -->
    <p style="text-align: center;">
        <form action="ExamServlet" method="get">
            <input type="hidden" name="action" value="add" />
            <input type="submit" value="Add Exam" />
        </form>
    </p>
</body>
</html>
