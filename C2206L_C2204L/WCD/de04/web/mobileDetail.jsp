<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
            .product-item {            
            border: 1px solid rgb(35, 39, 61);
            border-radius: 20px;
            padding: 20px;
            margin-bottom: 20px;
        }

        </style>
        <h1>Detail product</h1>
        <% 
          Product product = (Product)request.getAttribute("product");   
          int xx=1;
       %>
        <div class="col-lg-4 col-md-6">
                  <div class="product-item">
                      <a href="ProductServlet?id=<%= product.getId() %>">
                        <img src="<%= product.getUrl() %>" 
                             class="card-img-top" alt="Product Image" width="100">
                        <div class="card-body">
                           <h5 class="card-title"><%= product.getName() %></h5>
                           <p class="card-text"><strong>Price:</strong> <%= product.getPrice() %></p>
                        </div>
                     </a>
                  </div>
               </div>
         <a href="ProductServlet">Back to List</a>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
