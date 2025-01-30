<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="models.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Products</title>
    </head>
    <body>
        <h1>List of Products</h1>
        
        <!-- Form tìm kiếm sản phẩm -->
        <form action="${pageContext.request.contextPath}/products" method="get">
            <label for="searchText">Search by product name:</label>
            <input type="text" id="searchText" name="searchText" 
                   placeholder="Bạn muốn tìm gì" 
                   value="${param.searchText != null ? param.searchText : ''}">
            <button type="submit">Search</button>
        </form>
        <br>
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Tên sản phẩm</th>
                <th>Giá</th>
                <th>Mô tả</th>
                <th>Actions</th>
            </tr>
            <% 
                // Lấy danh sách sản phẩm từ request attribute
                List<Product> products = (List<Product>) request.getAttribute("products");
                if (products != null && !products.isEmpty()) {
                    for (Product product : products) { 
            %>
                        <tr>
                            <td><%= product.getId() %></td>
                            <td><%= product.getName() %></td>
                            <td><%= product.getPrice() %></td>
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
                } else { 
            %>
                    <tr>
                        <td colspan="5">No products found.</td>
                    </tr>
            <% 
                } 
            %>
        </table>
        
        <!-- Phân trang -->
        <div>
            <% 
                int currentPage = (int) request.getAttribute("currentPage");
                int totalPages = (int) request.getAttribute("totalPages");

                for (int i = 1; i <= totalPages; i++) { 
            %>
                <a href="${pageContext.request.contextPath}/products?page=<%=i%>&size=5<% 
                         if (request.getParameter("searchText") != null) { 
                             out.print("&searchText=" + request.getParameter("searchText")); 
                         } 
                     %>">
                    <% if (i == currentPage) { %>
                        <b><%=i%></b>
                    <% } else { %>
                        <%=i%>
                    <% } %>
                </a>
            <% 
                } 
            %>
        </div>

        
        <br>
        <a href="insertProduct.jsp">
            <button type="submit">Insert product</button>
        </a>
    </body>
</html>
