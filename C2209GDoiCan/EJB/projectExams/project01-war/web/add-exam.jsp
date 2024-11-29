<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Exam</title>
</head>
<body>
    <h2>Add New Exam</h2>
    <form action="ExamServlet" method="post">
        <input type="hidden" name="action" value="create" />
        <p>
            Name: <input type="text" name="name" required />
        </p>
        <p>
            Duration (minutes): <input type="number" name="duration" required />
        </p>
        <p>
            Description: <textarea name="description" rows="4" cols="50"></textarea>
        </p>
        <p>
            <input type="submit" value="Add Exam" />
        </p>
    </form>

    <!-- Nút quay lại danh sách kỳ thi -->
    <p>
        <form action="ExamServlet" method="get">
            <input type="hidden" name="action" value="list" />
            <input type="submit" value="Back to List" />
        </form>
    </p>
</body>
</html>
