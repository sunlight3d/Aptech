<%@page import="models.Product"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Data</title>
</head>
<body>
    <%
        Product product = (Product)request.getAttribute("product");
        
    %>
    <h1>Data from Servlet</h1>
        <p><%= request.getAttribute("message") %></p>
        <p><span>Name =</span><%= product.getName() %></p>
</body>
</html>
