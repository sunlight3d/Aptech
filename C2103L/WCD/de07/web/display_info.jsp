<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Information</title>
</head>
<body>
    <h2>Display Information</h2>
    <p><strong>Name:</strong> <%= request.getCookies()[0].getValue() %></p>
    <p><strong>Address:</strong> <%= request.getCookies()[1].getValue() %></p>
    <p><strong>Phone Number:</strong> <%= request.getCookies()[2].getValue() %></p>
    <p><strong>Class Name:</strong> <%= request.getCookies()[3].getValue() %></p>
</body>
</html>
