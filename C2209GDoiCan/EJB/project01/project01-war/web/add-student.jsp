<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Student</title>
</head>
<body>
    <h2>Add New Student</h2>
    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="create" />
        <p>
            Name: <input type="text" name="name" required />
        </p>
        <p>
            Age: <input type="number" name="age" required />
        </p>
        <p>
            Email: <input type="email" name="email" required />
        </p>
        <p>
            <input type="submit" value="Add Student" />
        </p>
    </form>

    <!-- Nút quay lại danh sách sinh viên -->
    <p>
        <form action="students" method="get">
            <input type="submit" value="Back to List" />
        </form>
    </p>
</body>
</html>
