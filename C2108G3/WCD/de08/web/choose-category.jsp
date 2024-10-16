<%-- 
    Document   : choose-category
    Created on : Oct 2, 2023, 10:25:15 AM
    Author     : hoangnd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Do you really want to assign product: ${product.getProductId()} to other category</h1>
        <form action="YourServletName" method="post">            
            <label for="categoryId">Select a new category:</label>
            <select name="categoryId" id="categoryId">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>

            <br>
            <input type="submit" value="Assign Product" 
                   action="/ProductServlet?action='assignCategory'&productId=${product.getProductId}&categoryId=${category.getCategoryId()}" 
                   method='post'>
        </form>
    </body>
</html>
