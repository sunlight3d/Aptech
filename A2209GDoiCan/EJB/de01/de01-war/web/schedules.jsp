<%@page import="java.util.List" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule List</title>
</head>
<body>
    <h2>Schedule List:</h2>
    <p><a href="home.jsp">Back home</a></p>
    
    <table border="1">
        <thead>
            <tr>
                <th>Exam Name</th>
                <th>Duration</th>
                <th>Time Slot</th>
                <th>Exam Sitter</th>
                <th>Start At</th>
                <th>End At</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Object[]> schedules = (List<Object[]>) request.getAttribute("schedules");
                if (schedules != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    for (Object[] row : schedules) {
            %>
            <tr>
                <td><%= row[0] %></td>
                <td><%= row[1] %></td>
                <td><%= row[2] %></td>
                <td><%= row[3] %></td>
                <td><%= sdf.format(row[4]) %></td>
                <td><%= sdf.format(row[5]) %></td>
                <td>
                    <a href="ExamServlet?action=cancel&id=<%= row[6] %>">Cancel</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>
