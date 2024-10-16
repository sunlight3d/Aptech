<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Book</title>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
    <h1>Insert Book</h1>
    <form action="BookServlet" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br><br>
        
        <label for="category">Category:</label>
        <select id="category" name="category">
            <c:forEach var="cat" items="${categories}">
                <option value="${cat}">${cat}</option>
            </c:forEach>
        </select><br><br>
        
        <label for="price">Price:</label>
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required>
        <span class="error">${priceError}</span>

        <input type="submit" value="Insert">
    </form>
</body>
</html>
