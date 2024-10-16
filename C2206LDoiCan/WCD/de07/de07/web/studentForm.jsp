<%-- 
    Document   : studentForm
    Created on : Mar 24, 2024, 11:03:57 AM
    Author     : ChungTV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Registration</title>
        <style>
            .form-group {
                margin-bottom: 10px;
            }
            label {
                display: inline-block;
                width: 100px;
                text-align: left;
            }
            input[type="text"] {
                width: 200px;
            }
            .error-message {
                color: red;
                margin-left: 10px;
            }
        </style>
    </head>
    <body>
        
        <h2>Student Registration Form</h2>
        <form action="StudentServlet" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${empty param.name ? '' : param.name}">
                <span class="error-message">${empty requestScope.nameError ? '' : requestScope.nameError}</span>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" value="${empty param.address ? '' : param.address}">
                <span class="error-message">${empty requestScope.addressError ? '' : requestScope.addressError}</span>
            </div>
            <div class="form-group">
                <label for="phone">Phone No:</label>
                <input type="text" id="phone" name="phone" value="${empty param.phone ? '' : param.phone}">
                <span class="error-message">${empty requestScope.phoneError ? '' : requestScope.phoneError}</span>
            </div>
            <div class="form-group">
                <label for="className">Class Name:</label>
                <input type="text" id="className" name="className" value="${empty param.className ? '' : param.className}">
               <span class="error-message">${empty requestScope.classError ? '' : requestScope.classError}</span>
            </div>
            <input type="submit" value="Submit Query">
        </form>
    </body>
</html>
