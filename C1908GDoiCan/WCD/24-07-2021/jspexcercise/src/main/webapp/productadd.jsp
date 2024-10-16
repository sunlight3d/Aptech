<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>

<div class="container mt-3">
<div class="d-flex justify-content-center">
<form action="products" method="POST">
 <table>
   <tr>
    <td>ID</td>
    <td><input type="text" name="productID" class="form-control"></td>    
  </tr>
  <tr>
  
  <tr>
    <td>Product's Name</td>
    <td><input type="text" name="productName" class="form-control"></td>    
  </tr>
  <tr>
    <td>Price</td>
    <td><input type="text" name="price" class="form-control"></td>    
  </tr>
  <tr>
    <td>Quantity</td>
    <td><input type="text" name="quantity" class="form-control"></td>    
  </tr>
 
</table> 
<button type="submit" class="btn btn-primary">Add product</button>
</form>
</div>
</div>
</body>
</html>