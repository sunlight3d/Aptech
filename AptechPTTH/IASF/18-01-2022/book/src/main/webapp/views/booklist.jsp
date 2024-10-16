<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>List All Books</h1>
    <table>
        <tr>
            <th>Book Id</th>
            <th>Title</th>
            <th>Category</th>
            <th>Price</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="hashtableBook" items="${books}">
            <tr>
                <td>${hashtableBook.get("bookID")}</td>
                <td>${hashtableBook.get("title")}</td>
                <td>${hashtableBook.get("categoryName")}</td>
                <td>${hashtableBook.get("price")}</td>
                <td><a href='/book/deleteBook?bookID=${hashtableBook.get("bookID")}'>Delete</a></td>
            </tr>
            </c:forEach>

    </table>
    <a href="/book/welcome">Return to welcome page</a></td>
</body>
</html>