<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<!-- <h1 style="color:red;">Error</h1> -->
	<h1 style="color:red;"><%= (String)request.getAttribute("errorMessage")%></h1>		
</body>
</html>