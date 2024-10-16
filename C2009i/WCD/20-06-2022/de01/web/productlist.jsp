<%@page import="java.util.*"%>
<%@page import="models.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        table, th, td {
          border:1px solid black;
          margin: 10px;
        }
        </style>
    </head>
    <body>
    <center>
        <form>                    
        <h1>Product Manager</h1>
        <span>Search</span>
        <input type="text" name="typedText">
        <input type="submit" value="Search">
        <table>
            <tr>
                <th>
                    ID
                </th>
                <th>
                    ProductName
                </th>
                <th>
                    Price
                </th>
                <th>
                    Quantity
                </th>
                <th>
                    Delete
                </th>                
            </tr>
            <%            
                List<Product> products = (List<Product>)request.getAttribute("products");            
                for(Product product: products) {
                    out.print("<tr>");        
                    out.print("<td>"+product.getId()+"</td>");
                    out.print("<td>"+product.getProductName()+"</td>");
                    out.print("<td>"+product.getPrice()+"</td>");
                    out.print("<td>"+product.getQuantity()+"</td>");
                    out.print("<td><a href='ProductServlet?id="+product.getId()+"'>Delete</a></td>");
                    out.print("</tr>");                    
                }
            %>               
        </table>
        <a href="addnew.jsp" >Add new</a>
    </form>
    </center>
        
    </body>
</html>
