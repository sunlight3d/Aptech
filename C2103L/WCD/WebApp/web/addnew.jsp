<!DOCTYPE html>
<html>
<head>
    <title>Add New Product</title>
</head>
<body>
    <h1>Add New Product</h1>
    <form action="ProductServlet" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required /><br/><br/>
        
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" required /><br/><br/>
        
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required /><br/><br/>
        
        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" name="price" required /><br/><br/>
        
        <input type="submit" value="Save" />
    </form>
</body>
</html>
