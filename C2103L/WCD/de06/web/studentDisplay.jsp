<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
</head>
<body>
    <h2>Student Information</h2>
    <p>Name: <%= request.getParameter("name") %></p>
    <p>Address: <%= request.getParameter("address") %></p>
    <p>Phone No: <%= request.getParameter("phoneNo") %></p>
    <p>Class Name: <%= request.getParameter("className") %></p>
</body>
</html>
