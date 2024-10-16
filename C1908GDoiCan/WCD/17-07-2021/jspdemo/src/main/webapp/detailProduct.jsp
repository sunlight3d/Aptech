<%@page import="com.aptech.jspdemo.models.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is detail product</h1>
	<%
		Product product = (Product)request.getAttribute("product");
		out.println(product);
	%>
</body>
</html>