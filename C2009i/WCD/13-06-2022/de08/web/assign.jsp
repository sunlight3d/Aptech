<%@page import="java.util.List"%>
<%@page import="com.models.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%            
            List<Category> categories = (List<Category>)request.getAttribute("categories");
            Product product = (Product)request.getAttribute("product");            
        %>    </head>
    <body>
        <h1>Hello World!</h1>        
        <h3> Do you want to assign product <%= product.getName() %></h3>
        <form action="${pageContext.request.contextPath}/ProductServlet" method="POST">
            <select name="categoryId">
                <%
                    for (Category category : categories) {
                       out.println("<option value=\""+category.getId()
                               +"\">"+category.getName()+"</option>");
                    }
                    
                %>                
            </select>
            <input type="hidden" value="<%=product.getId()%>" name="productId"/>                       
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
