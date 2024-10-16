<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mobile Detail</title>
</head>
<body>
    <h1>Mobile Detail</h1>
    <table>
        <tr>
            <td>ID:</td>
            <td>${mobile.mobileId}</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>${mobile.mobileName}</td>
        </tr>
        <tr>
            <td>Warranty:</td>
            <td>${mobile.warranty}</td>
        </tr>
        <tr>
            <td>In Stock:</td>
            <td>${mobile.inOutStock == 1 ? 'Yes' : 'No'}</td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>${mobile.price}</td>
        </tr>
        <tr>
            <td>Accessories:</td>
            <td>${mobile.accessories}</td>
        </tr>
        <tr>
            <td>Image:</td>
            <td><img src="${mobile.imageSrc}" 
                     alt="${mobile.mobileName}" width="100" height="100"></td>
        </tr>
    </table>
    <a href="home.jsp">Back to Mobile List</a>
</body>
</html>

