<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Company Information</title>
</head>
<body>
    <h1>Update Company Information</h1>
    <form action="updateCompany" method="post">
        <input type="hidden" name="companyId" value="${company.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${company.name}"><br>
        <label for="key">Key:</label>
        <input type="text" id="key" name="key" value="${company.key}"><br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="${company.description}"><br>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${company.address}"><br>
        <label for="enabled">Enabled:</label>
        <input type="checkbox" id="enabled" name="enabled" ${company.enabled ? 'checked' : ''}><br>
        <button type="submit">Save Changes</button>
    </form>
    <p>${message}</p>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
