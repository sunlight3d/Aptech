<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Information</title>
</head>
<body>
    <h2>Add Information</h2>
    <form action="SaveInfoServlet" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>
        <br>
        
        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" required>
        <br>
        
        <label for="className">Class Name:</label>
        <input type="text" id="className" name="className" required>
        <br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
