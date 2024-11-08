<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert Product</title>
</head>
<body>
    <h1>Thêm sản phẩm mới</h1>
     <form action="${pageContext.request.contextPath}/products" method="post">
        <label for="name">Tên sản phẩm:</label>
        <input type="text" id="name" name="name" required>
        <br><br>
        <label for="price">Giá:</label>
        <input type="number" step="0.01" id="price" name="price" required>
        <br><br>
        <label for="quantity">Số lượng:</label>
        <input type="number" id="quantity" name="quantity" required>
        <br><br>
        <label for="description">Mô tả:</label>
        <textarea id="description" name="description"></textarea>
        <br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
