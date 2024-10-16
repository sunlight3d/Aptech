<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    <form action="ProductServlet" method="POST">
        <input type="hidden" name="action" value="add">
        <label for="productId">ID:</label>
        <input type="text" id="productId" name="productId" required><br><br>
        
        <label for="productName">Product Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" min="0" step="0.01" required><br><br>
        
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" min="0" required><br><br>
        
        <button type="submit">Submit</button>
        
    </form>
</body>
</html>
