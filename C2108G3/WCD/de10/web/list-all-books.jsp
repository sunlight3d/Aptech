<%@ page language="java" 
         contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
</head>
<body>
    <h1>Book List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Category</th>
            <th>Price</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.category}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<!--
CREATE TABLE books(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    category VARCHAR(20) NOT NULL,
	price float
);

INSERT INTO books (title, category, price) VALUES
('Book 1', 'Fiction', 12.99),
('Book 2', 'Science', 19.99),
('Book 3', 'History', 15.50),
('Book 4', 'Mystery', 14.75),
('Book 5', 'Romance', 10.99),
('Book 6', 'Science Fiction', 18.25),
('Book 7', 'Biography', 16.00),
('Book 8', 'Fantasy', 13.49),
('Book 9', 'Self-Help', 9.95),
('Book 10', 'Cooking', 20.00);

-->