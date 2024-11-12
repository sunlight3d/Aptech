<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="models.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of products</h1>
         <table border="1">
            <tr>
                <th>ID</th>
                <th>Tên sản phẩm</th>
                <th>Giá</th>
                <th>Số lượng</th>
                <th>Mô tả</th>
            </tr>
            <% 
                // Lấy danh sách sản phẩm từ request attribute
                List<Product> products = (List<Product>) request.getAttribute("products");
                for (Product product : products) { 
            %>
                <tr>
                    <td><%= product.getId() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><%= product.getQuantity() %></td>
                    <td><%= product.getDescription() %></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/products" 
                              method="post" style="display:inline;">
                            <input type="hidden" name="_method" value="delete">
                            <input type="hidden" name="id" value="<%= product.getId() %>">
                            <button type="submit">Delete</button>
                        </form>

                        
                        <form action="${pageContext.request.contextPath}/products" 
                              method="get" style="display:inline;">
                            <input type="hidden" name="id" value="<%= product.getId() %>">
                            <input type="hidden" name="_method" value="update">
                            <button type="submit">Update</button>
                        </form>
                    </td>
                </tr>
            <% 
                } 
            %>
        </table>
        <br>
        <a href="insertProduct.jsp">
            <button type="submit">Insert product</button>
        </a>        
    </body>
</html>
