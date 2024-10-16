<%@page import="com.aptech.Database"%>
<%@page import="com.aptech.models.Category"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="assign.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <%
            //get all categories
            List<Category> categories = Database.GetInstance().getCategories();
            int productId = Integer.valueOf(request.getParameter("productId"));
            request.setAttribute("productId", productId);              
            request.setAttribute("categories", categories);              
        %>
        <h1 id="title"></h1>
        <form action="categoryServlet" method="POST"> 
            <select name="categories" id="categories" onchange="changeCategory()">
                <c:forEach var ="category" items = "${requestScope.categories}">
                    <option value=${category.name}>${category.name}</option>
                </c:forEach>                             
            </select>
            <input type="hidden" name="productId" value= "${requestScope.productId}">
            <button type="submit" name="btnUpdate">Update</button>
        </form>
        
    </body>

</html>
