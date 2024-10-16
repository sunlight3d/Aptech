<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
</head>
<body>
    <h2>Student Registration</h2>
    <form action="StudentServlet" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>
        <br>
        
        <label for="phoneNo">Phone No:</label>
        <input type="text" id="phoneNo" name="phoneNo" required>
        <br>
        
        <label for="className">Class Name:</label>
        <input type="text" id="className" name="className" required>
        <br>
        
        <input type="submit" value="Submit Query">
    </form>
</body>
</html>
