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
    <h2>Insert new book</h2>
    <form method="post" action="/book/insertconfirmed">
        <table>
            <tr>
                <td>Title</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>Category</td>
                <td>
                    <select name='categoryID'>
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.getCategoryID()}">${category.getCategoryName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" name="price"></td>
            </tr>

        </table>        
        <input type="submit" value="insert">
    </form>
   
</body>

</html>