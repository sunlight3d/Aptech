<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome</h1>
    <p>Name: <%= request.getAttribute("name") %></p>
    <p>Address: <%= request.getAttribute("address") %></p>
    <p>Phone Number: <%= request.getAttribute("phone") %></p>
    <p>Class Name: <%= request.getAttribute("className") %></p>
</body>
</html>
