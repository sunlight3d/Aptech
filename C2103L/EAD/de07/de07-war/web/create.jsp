<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Student</title>
</head>
<body>
    <h1>Create Student</h1>
    
    <form action="createStudent" method="post">
        <label for="rollnumber">Roll Number:</label>
        <input type="text" id="rollnumber" name="rollnumber"><br>
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        
        <label for="email">Email:</label>
        <input type="text" id="email" name="email"><br>
        
        <label for="age">Age:</label>
        <input type="text" id="age" name="age"><br>
        
        <input type="submit" value="Create">
    </form>
    
    <p><a href="index.jsp">Back to Student List</a></p>
</body>
</html>
