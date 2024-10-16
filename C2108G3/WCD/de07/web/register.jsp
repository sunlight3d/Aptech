<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="UserServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address"><br>
        
        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone"><br>
        
        <label for="className">Class Name:</label>
        <input type="text" id="className" name="className"><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
