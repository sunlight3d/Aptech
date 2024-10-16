<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Company Details</title>
</head>
<body>
    <h1>Company Details</h1>
    <p><strong>Name:</strong> ${company.name}</p>
    <p><strong>Key:</strong> ${company.key}</p>
    <p><strong>Description:</strong> ${company.description}</p>
    <p><strong>Address:</strong> ${company.address}</p>
    <p><strong>Enabled:</strong> ${company.enabled ? 'Yes' : 'No'}</p>
    <a href="index.jsp">Back to Home</a>
</body>
</html>

