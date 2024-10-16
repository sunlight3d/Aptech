
<%@page import="java.util.List"%>
<%@page import="models.Mobile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Mobiles</title>    
</head>
<body>
    <h1>List of Mobiles</h1>
   
    <table border="1">        
        <tbody>
            <%
            List<Mobile> mobiles = (List<Mobile>) request.getAttribute("mobiles");
            int count = 0; // Biến đếm để theo dõi số sản phẩm đã hiển thị
            for (Mobile mobile : mobiles) {
                if (count % 3 == 0) {
                    // Bắt đầu một hàng mới (mỗi hàng có 3 sản phẩm)
                    if (count > 0) {
            %>
                    </tr> <!-- Kết thúc hàng trước -->
            <%
                    }
            %>
                    <tr> <!-- Bắt đầu hàng mới -->
            <%
                }
            %>
                        <td>
                            <img src="<%= mobile.getImageSrc() %>" alt="<%= mobile.getMobileName() %>" width="100" height="100"><br>
                            <strong>Name:</strong> <%= mobile.getMobileName() %><br>
                            <strong>Warranty:</strong> <%= mobile.getWarranty() %><br>
                            <strong>In Stock:</strong> <%= (mobile.getInOutStock() == 1) ? "Yes" : "No" %><br>
                            <strong>Price:</strong> <%= mobile.getPrice() %><br>
                            <strong>Accessories:</strong> <%= mobile.getAccessories() %>
                        </td>
            <%
                count++;
            }
            %>
            </tr> <!-- Kết thúc hàng cuối cùng -->
        </tbody>
        <a href="create-mobile.jsp">Insert new product</a>

    </table>
</body>
</html>

