
<%@page import="java.util.List"%>
<%@page import="com.aptech.models.Product"%>
<%@page import="com.aptech.Database"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        table, th, td {
          border: 1px solid black;
        }
        </style>
    </head>
    <body>
        <h2>Product List</h2>
        <%
            out.println("haha");
            if(request.getParameter("categoryId") != null) {
                int categoryId = Integer.valueOf(request.getParameter("categoryId"));
                out.println("aaa");
                List<Product> products = Database.GetInstance().getProductsFromGategoryId(categoryId);            
                request.setAttribute("products", products);              
            }                       
        %>
        <table style="width:100%">
          <tr>
            <th>ID</th>
            <th>Name</th> 
            <th>Price</th>
            <th>Description</th>
            <th>Actions</th>             
          </tr>
           <c:forEach var ="product" items = "${requestScope.products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>
                        <a href="assign.jsp?productId=${product.id}">
                            Assign this product to other Category
                        </a>
                    </td>                    
                </tr>            
            </c:forEach>          
        </table>
        <!--Google search: navigation, route-->
        <a href="category.jsp">Back to category</a>
    </body>
</html>
