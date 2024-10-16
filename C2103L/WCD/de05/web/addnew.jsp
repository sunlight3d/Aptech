<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Product</title>
</head>
<body>
    <h2>Add New Product</h2>
    <form action="ProductServlet?action=insert" method="POST">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id"><br>
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName"><br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price"><br>
        <label for="quantity">Quantity:</label>
        <input type="text" id="quantity" name="quantity"><br>
        <input type="submit" value="Insert">
    </form>
</body>
</html>
