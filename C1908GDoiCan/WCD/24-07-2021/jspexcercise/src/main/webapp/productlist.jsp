<%@page import="com.aptech.models.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

<title>Product list</title>
</head>
<body>
<form>
<div class="container">
<div class="d-flex justify-content-center">
<div class="row container">
	    <div class="row g-3 container d-flex justify-content-center" >
		  <div class="col-auto pt-1">
		    <label for="staticEmail2">Search</label>		    
		  </div>
		  <div class="col-auto ml-2">		    
		    <input type="text" class="form-control" placeholder="Enter text to search">
		  </div>
		  <div class="col-auto">
		    <button type="submit" class="btn btn-primary mb-3">Search</button>
		  </div>
		</div>
  </div>
</div>

<table class="table table-success table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
    <!-- <tr>
      <th scope="row">1</th>
      <td>Macbook pro</td>
      <td>1234$</td>
      <td>12</td>
      <td><a href="#" class="link-danger">Delete</a></td>
    </tr> -->    
    <%
    	out.println("kaka");
    	List<Product> products = (List<Product>)request.getAttribute("products");
		for(Product product: products) {
			out.println("<tr>");
			out.println("<th scope=\"row\">1</th>");			
			out.println(String.format("<td>%s</td>", product.getProductName()));
			out.println(String.format("<td>%f$</td>", product.getPrice()));
			out.println(String.format("<td>%d</td>", product.getQuantity()));		      
			out.println("<td><a href=\"#\" class=\"link-danger\">Delete</a></td>");		    
		}    		
    %>    
  </tbody>
</table>	
<div class="col-auto">
	<a type="submit" class="link-primary mb-3">Add New</a>
</div>
</div>
</form>
</body>
</html>